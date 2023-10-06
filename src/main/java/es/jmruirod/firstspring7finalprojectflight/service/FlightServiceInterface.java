package es.jmruirod.firstspring7finalprojectflight.service;

import java.util.List;

import es.jmruirod.firstspring7finalprojectflight.model.Flight;

/**
 * Interfaz que define los servicios relacionados con los vuelos en la aplicación.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public interface FlightServiceInterface 
{
    /**
     * Busca y devuelve una lista de vuelos con un número de asientos disponibles mayor al valor proporcionado.
     *
     * @param seats El número de asientos disponibles que deben tener los vuelos en la lista.
     * @return Una lista de vuelos con un número de asientos disponibles mayor al valor especificado.
     */
    public List<Flight> findByAvailableSeats(int seats);

    /**
     * Actualiza el número de asientos disponibles para un vuelo específico.
     *
     * @param id            El identificador único del vuelo que se actualizará.
     * @param availableSeats El nuevo número de asientos disponibles para el vuelo.
     */
    public void updateAvailableSeats(long id, int availableSeats);
}
