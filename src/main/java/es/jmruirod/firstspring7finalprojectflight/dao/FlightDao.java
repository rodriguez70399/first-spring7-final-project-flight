package es.jmruirod.firstspring7finalprojectflight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;

public interface FlightDao extends JpaRepository<Flight, Long>
{
    public List<Flight> findByAvailableSeatsGreaterThan(int seats);
}
