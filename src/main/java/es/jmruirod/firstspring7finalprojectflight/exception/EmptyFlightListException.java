package es.jmruirod.firstspring7finalprojectflight.exception;

/**
 * Excepción personalizada que se lanza cuando la lista de vuelos está vacía.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public class EmptyFlightListException extends RuntimeException
{
    /**
     * Constructor de la excepción que indica que la lista de vuelos está vacía.
     */
    public EmptyFlightListException()
    {
        super("No hotels registered");
    }
}