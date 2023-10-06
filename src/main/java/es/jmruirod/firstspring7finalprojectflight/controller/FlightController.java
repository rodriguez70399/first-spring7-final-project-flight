package es.jmruirod.firstspring7finalprojectflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jmruirod.firstspring7finalprojectflight.exception.BadRequestException;
import es.jmruirod.firstspring7finalprojectflight.model.Flight;
import es.jmruirod.firstspring7finalprojectflight.service.FlightServiceInterface;

@RestController
public class FlightController 
{
    @Autowired
    private FlightServiceInterface service;

    @GetMapping(value = "flights/{seats}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> findByAvailableSeats(@PathVariable String seats) 
    {
        int numericSeats;

        try 
        {
            numericSeats = Integer.parseInt(seats);            
        } 
        catch (NumberFormatException e) 
        {
            throw new BadRequestException("Invalid parameter data type.");
        }

        return this.service.findByAvailableSeats(numericSeats); 
    }

    @PutMapping(value = "flight/{id}/{availableSeats}")
    public void updateAvailableSeats(@PathVariable String id, @PathVariable String availableSeats) 
    {
        long numericID;
        int numericSeats;

        try 
        {
            numericID = Long.parseLong(id);
            numericSeats = Integer.parseInt(availableSeats);            
        } 
        catch (NumberFormatException e) 
        {
            throw new BadRequestException("Invalid parameter data type.");
        }

        this.service.updateAvailableSeats(numericID, numericSeats);
    }
}