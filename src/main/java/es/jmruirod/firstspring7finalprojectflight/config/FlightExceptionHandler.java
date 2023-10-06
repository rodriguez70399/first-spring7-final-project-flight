package es.jmruirod.firstspring7finalprojectflight.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.jmruirod.firstspring7finalprojectflight.exception.BadRequestException;
import es.jmruirod.firstspring7finalprojectflight.exception.EmptyFlightListException;
import es.jmruirod.firstspring7finalprojectflight.exception.FlightNotFoundException;

/**
 * Clase que maneja las excepciones personalizadas en la aplicación y las convierte en respuestas HTTP apropiadas.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@ControllerAdvice
public class FlightExceptionHandler 
{
    /**
     * Maneja la excepción FlightNotFoundException y devuelve una respuesta HTTP 404 (Not Found) con un mensaje.
     *
     * @param exception La excepción FlightNotFoundException lanzada.
     * @return Un mensaje de error con la descripción de la excepción.
     */
    @ResponseBody
    @ExceptionHandler(FlightNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String flightNotFoundHandler(FlightNotFoundException exception)
    {
        return exception.getMessage();
    }

    /**
     * Maneja la excepción EmptyFlightListException y devuelve una respuesta HTTP 404 (Not Found) con un mensaje.
     *
     * @param exception La excepción EmptyFlightListException lanzada.
     * @return Un mensaje de error con la descripción de la excepción.
     */
    @ResponseBody
    @ExceptionHandler(EmptyFlightListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String emptyHotelListHandler(EmptyFlightListException exception)
    {
        return exception.getMessage();
    }

    /**
     * Maneja la excepción BadRequestException y devuelve una respuesta HTTP 400 (Bad Request) con un mensaje.
     *
     * @param exception La excepción BadRequestException lanzada.
     * @return Un mensaje de error con la descripción de la excepción.
     */
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequestHandler(BadRequestException exception)
    {
        return exception.getMessage();
    }
}