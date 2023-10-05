package es.jmruirod.firstspring7finalprojectflight.service;

import java.util.List;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;

public interface FlightServiceInterface 
{
    public List<Flight> findByAvailableSeats(int seats);
    public void updateAvailableSeats(long id, int availableSeats);
}
