package es.jmruirod.firstspring7finalprojectflight.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Flight.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public interface FlightDao extends JpaRepository<Flight, Long>
{
    /**
     * Busca y devuelve una lista de vuelos con un número de asientos disponibles mayor que el valor proporcionado.
     *
     * @param seats El número mínimo de asientos disponibles que deben tener los vuelos en la lista.
     * @return Una lista de vuelos con un número de asientos disponibles mayor que el valor especificado.
     */
    public List<Flight> findByAvailableSeatsGreaterThan(int seats);
}

