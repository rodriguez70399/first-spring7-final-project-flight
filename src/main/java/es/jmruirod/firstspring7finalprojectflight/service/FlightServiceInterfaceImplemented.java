package es.jmruirod.firstspring7finalprojectflight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring7finalprojectflight.dao.FlightDao;
import es.jmruirod.firstspring7finalprojectflight.exception.EmptyFlightListException;
import es.jmruirod.firstspring7finalprojectflight.exception.FlightNotFoundException;
import es.jmruirod.firstspring7finalprojectflight.model.Flight;

@Service
public class FlightServiceInterfaceImplemented implements FlightServiceInterface
{
    @Autowired
    private FlightDao flightDao;

    @Override
    public List<Flight> findByAvailableSeats(int seats) 
    {
        List<Flight> flights = this.flightDao.findByAvailableSeatsGreaterThan(seats);

        if (flights.isEmpty()) 
        {
            throw new EmptyFlightListException();
        }

        return this.flightDao.findByAvailableSeatsGreaterThan(seats);
    }

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
