package com.example.aerolinea.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aerolinea.api.dto.BookingCreationDto;
import com.example.aerolinea.api.dto.BookingDto;
import com.example.aerolinea.api.dto.BookingMapper;
import com.example.aerolinea.entities.Booking;
import com.example.aerolinea.exceptions.BookingNotFoundException;
import com.example.aerolinea.exceptions.DuplicateCodigoException;
import com.example.aerolinea.services.BookingService;

@RestController
@RequestMapping("aerolinea/v1")
public class BookingController {
    private final BookingService bookingservice;
    private final BookingMapper bookingmapper;

    public BookingController(BookingService bookingservice, BookingMapper bookingmapper) {
        this.bookingservice = bookingservice;
        this.bookingmapper = bookingmapper;
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<BookingCreationDto>> findAll(){
        List<Booking> bookings = bookingservice.findAll();
        List<BookingCreationDto> bookingcreationdto = bookings.stream()
                           .map(b -> bookingmapper.toBookingCreationDto(b))
                           .collect(Collectors.toList());
        return ResponseEntity.ok().body(bookingcreationdto);                   
    }

    @GetMapping("/catalogs/{id}")
    public ResponseEntity<BookingCreationDto> findbyId(@PathVariable("id")Long id){
        BookingCreationDto booking = bookingservice.findById(id)
                     .map(b -> bookingmapper.toBookingCreationDto(b))
                     .orElseThrow(BookingNotFoundException :: new);
        return ResponseEntity.status(HttpStatus.FOUND).body(booking);              
    }

    @PostMapping("/catalog")
    public ResponseEntity<BookingCreationDto> create(@RequestBody BookingDto booking){
        Booking newBooking = bookingmapper.toEntity(booking);
        Booking bookingcreated = null;

        try{
            bookingcreated = bookingservice.create(newBooking);
        } catch(Exception e){
            throw new DuplicateCodigoException();
        }

        BookingCreationDto bookingcreationdto = bookingmapper.toBookingCreationDto(bookingcreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(bookingcreationdto.getId())
                        .toUri();
        return ResponseEntity.created(location).body(bookingcreationdto);
    }

    @PutMapping("/catalogs/{id}")
    public ResponseEntity<BookingCreationDto> update(@PathVariable ("id")Long id, @RequestBody BookingCreationDto booking){
        Booking bookingtoupdate = bookingmapper.toUserEntity(booking);
        return bookingservice.update(id, bookingtoupdate)
                        .map(b -> ResponseEntity.ok().body(bookingmapper.toBookingCreationDto(bookingtoupdate)))
                        .orElseGet(()-> {
                            BookingCreationDto bookingcreationdto = bookingmapper.toBookingCreationDto(bookingtoupdate);
                            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(bookingcreationdto.getId())
                            .toUri();
        return ResponseEntity.created(location).body(bookingcreationdto);
                        });
    }

    @DeleteMapping("/catalogs/{id}")
    public void delete(@PathVariable ("id") Long id){
        bookingservice.deleteById(id);  
}
}
