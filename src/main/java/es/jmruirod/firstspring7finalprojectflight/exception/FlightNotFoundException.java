package es.jmruirod.firstspring7finalprojectflight.exception;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un Vuelo.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public class FlightNotFoundException extends RuntimeException
{
    /**
     * Constructor de la excepción para un vuelo no encontrado por su identificador único.
     *
     * @param id El identificador único del vuelo no encontrado.
     */
    public FlightNotFoundException(Long id)
    {
        super("Could not find flight " + id);
    }
}
