package es.jmruirod.firstspring7finalprojectflight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring7finalprojectflight.dao.FlightDao;
import es.jmruirod.firstspring7finalprojectflight.exception.EmptyFlightListException;
import es.jmruirod.firstspring7finalprojectflight.exception.FlightNotFoundException;
import es.jmruirod.firstspring7finalprojectflight.model.Flight;

/**
 * Implementación de la interfaz FlightServiceInterface que proporciona servicios relacionados con los vuelos en la aplicación.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Service
public class FlightServiceInterfaceImplemented implements FlightServiceInterface
{
    @Autowired
    private FlightDao flightDao;

    /**
     * Busca y devuelve una lista de vuelos con un número de asientos disponibles mayor que el valor proporcionado.
     *
     * @param seats El número de asientos disponibles que deben tener los vuelos en la lista.
     * @return Una lista de vuelos con un número de asientos disponibles mayor que el valor especificado.
     * @throws EmptyFlightListException Si no se encuentran vuelos que cumplan con el criterio de búsqueda.
     */
    @Override
    public List<Flight> findByAvailableSeats(int seats) 
    {
        List<Flight> flights = this.flightDao.findByAvailableSeatsGreaterThan(seats);

        if (flights.isEmpty()) 
        {
            throw new EmptyFlightListException();
        }

        return flights;
    }

    /**
     * Actualiza el número de asientos disponibles para un vuelo específico.
     *
     * @param id            El identificador único del vuelo que se actualizará.
     * @param availableSeats El nuevo número de asientos disponibles para el vuelo.
     * @throws FlightNotFoundException Si no se encuentra un vuelo con el identificador proporcionado.
     */
    @Override
    public void updateAvailableSeats(long id, int availableSeats) 
    {
        Flight flight = this.flightDao.findById(id).orElse(null);

        if (flight == null) 
        {
            throw new FlightNotFoundException(id);
        }
        
        flight.setAvailableSeats(availableSeats);
        this.flightDao.save(flight);
    }
}
