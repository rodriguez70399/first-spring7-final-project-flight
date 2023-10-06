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

/**
 * Controlador que maneja las solicitudes relacionadas con los vuelos en la aplicación.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@RestController
public class FlightController 
{
    @Autowired
    private FlightServiceInterface service;

    /**
     * Busca y devuelve una lista de vuelos con un número de asientos disponibles mayor al valor proporcionado.
     *
     * @param seats El número de asientos disponibles que deben tener los vuelos en la lista.
     * @return Una lista de vuelos con un número de asientos disponibles mayor al valor especificado.
     * @throws BadRequestException Si se proporciona un valor no válido o no numérico en el parámetro "seats".
     * @apiNote GET: localhost/PUERTO/flights/24
     */
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

    /**
     * Actualiza el número de asientos disponibles para un vuelo específico.
     *
     * @param id            El identificador único del vuelo que se actualizará.
     * @param availableSeats El nuevo número de asientos disponibles para el vuelo.
     * @throws BadRequestException Si se proporcionan valores no válidos o no numéricos en los parámetros "id" o "availableSeats".
     * @apiNote PUT: localhost/PUERTO/flights/1/23
     */
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