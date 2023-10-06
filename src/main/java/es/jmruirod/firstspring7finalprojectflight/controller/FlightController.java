package es.jmruirod.firstspring7finalprojectflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;
import es.jmruirod.firstspring7finalprojectflight.service.FlightServiceInterface;

@RestController
public class FlightController 
{
    @Autowired
    private FlightServiceInterface service;

    @GetMapping(value = "flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> findByAvailableSeats(int seats) 
    {
        return this.service.findByAvailableSeats(seats); 
    }

    @PutMapping(value = "flight/{id}/{availableSeats}")
    public void updateAvailableSeats(@PathVariable long id, @PathVariable int availableSeats) 
    {
        this.service.updateAvailableSeats(id, availableSeats);
    }
}
