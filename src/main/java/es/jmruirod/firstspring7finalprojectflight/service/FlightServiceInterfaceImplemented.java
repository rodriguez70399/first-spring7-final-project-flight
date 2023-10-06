package es.jmruirod.firstspring7finalprojectflight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jmruirod.firstspring7finalprojectflight.dao.FlightDao;
import es.jmruirod.firstspring7finalprojectflight.model.Flight;

@Service
public class FlightServiceInterfaceImplemented implements FlightServiceInterface
{
    @Autowired
    private FlightDao flightDao;

    @Override
    public List<Flight> findByAvailableSeats(int seats) 
    {
        return this.flightDao.findByAvailableSeats(seats);
        
    }

    @Override
    public void updateAvailableSeats(long id, int availableSeats) 
    {
        Flight flight = this.flightDao.findById(id).orElse(null);
        flight.setAvailableSeats(availableSeats);
        this.flightDao.save(flight);
    }
}
