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

import com.example.aerolinea.api.dto.FlightCreationDto;
import com.example.aerolinea.api.dto.FlightDto;
import com.example.aerolinea.api.dto.FlightMapper;
import com.example.aerolinea.entities.Flight;
import com.example.aerolinea.exceptions.DuplicateCodigoException;
import com.example.aerolinea.exceptions.FlightNotFoundException;
import com.example.aerolinea.services.FlightService;

@RestController
@RequestMapping("/aerolinea/v1/")
public class FlightController {
    private final FlightService flightservice;
    private final FlightMapper flightmapper;

    public FlightController(FlightService flightservice, FlightMapper flightmapper) {
        this.flightservice = flightservice;
        this.flightmapper = flightmapper;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<FlightCreationDto>> findAll(){
        List<Flight> flights = flightservice.findAll();
        List<FlightCreationDto> flightcreationdto = flights.stream()
                                             .map(f -> flightmapper.toFlightCreationDto(f))
                                             .collect(Collectors.toList());
        return ResponseEntity.ok().body(flightcreationdto);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<FlightCreationDto> findbyId(@PathVariable ("id") Long id){
        FlightCreationDto flight = flightservice.findById(id)
                      .map(f -> flightmapper.toFlightCreationDto(f))
                      .orElseThrow(FlightNotFoundException :: new);
        return ResponseEntity.status(HttpStatus.FOUND).body(flight);               
    }

    @PostMapping("/flight")
    public ResponseEntity<FlightCreationDto> create(@RequestBody FlightDto flight){
        Flight newFlight = flightmapper.toEntity(flight);
        Flight flightcreated = null;

        try{
            flightcreated = flightservice.create(newFlight);
        } catch(Exception e){
            throw new DuplicateCodigoException();
        }

        FlightCreationDto flightcreationdto = flightmapper.toFlightCreationDto(flightcreated);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(flightcreationdto.getId())
                        .toUri();
        return ResponseEntity.created(location).body(flightcreationdto);                
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<FlightCreationDto> update(@PathVariable("id")Long id, @RequestBody FlightCreationDto flight){
        Flight flighttoupdate = flightmapper.toUserEntity(flight);
        return flightservice.update(id, flighttoupdate)
                 .map(f -> ResponseEntity.ok().body(flightmapper.toFlightCreationDto(flighttoupdate)))
                 .orElseGet(() -> {
                    FlightCreationDto flightcreationdto = flightmapper.toFlightCreationDto(flighttoupdate);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(flightcreationdto.getId())
                                    .toUri();
                    return ResponseEntity.created(location).body(flightcreationdto);
                 });
    }

    @DeleteMapping("/flights/{id}")
    public void delete(@PathVariable ("id") Long id){
        flightservice.deleteById(id);
    }

    

    
}
