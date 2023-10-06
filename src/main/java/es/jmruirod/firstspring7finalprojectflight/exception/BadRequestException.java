package es.jmruirod.firstspring7finalprojectflight.exception;

/**
 * Excepción personalizada que se lanza cuando se recibe una solicitud incorrecta o inválida (código de estado 400).
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
public class BadRequestException extends RuntimeException
{
    /**
     * Constructor de la excepción con un mensaje personalizado.
     *
     * @param message El mensaje que describe la solicitud incorrecta o inválida.
     */
    public BadRequestException(String message)
    {
        super(message);
    }
}