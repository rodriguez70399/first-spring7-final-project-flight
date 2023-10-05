package es.jmruirod.firstspring7finalprojectflight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;

public interface FlightDao extends JpaRepository<Flight, Long>
{
    @Query("SELECT f FROM Flight WHERE f.availableSeats > :seats")
    public List<Flight> findByAvailableSeats(@Param("seats") int seats);
}
