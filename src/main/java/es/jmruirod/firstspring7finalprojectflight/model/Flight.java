package es.jmruirod.firstspring7finalprojectflight.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * Clase que representa un vuelo en el sistema.
 * 
 * @author Jose Manuel Ruiz Rodriguez
 */
@Entity
@Table(name = "flights")
public class Flight 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    private double price;
    private int availableSeats;
    
    /**
     * Constructor sin argumentos de la clase Flight.
     */
    public Flight() 
    {

    }

    /**
     * Constructor de la clase Flight que recibe parámetros para inicializar sus atributos.
     *
     * @param company       La compañía del vuelo.
     * @param date          La fecha y hora del vuelo.
     * @param price         El precio del vuelo.
     * @param availableSeats El número de asientos disponibles en el vuelo.
     */
    public Flight(String company, LocalDateTime date, double price, int availableSeats) 
    {
        this.company = company;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    /**
     * Constructor de la clase Flight que recibe un identificador único además de otros parámetros.
     *
     * @param id            El identificador único del vuelo.
     * @param company       La compañía del vuelo.
     * @param date          La fecha y hora del vuelo.
     * @param price         El precio del vuelo.
     * @param availableSeats El número de asientos disponibles en el vuelo.
     */
    public Flight(long id, String company, LocalDateTime date, double price, int availableSeats) 
    {
        this.id = id;
        this.company = company;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    /**
     * Obtiene el identificador único del vuelo.
     *
     * @return El identificador único del vuelo.
     */
    public long getId() 
    {
        return id;
    }

    /**
     * Establece el identificador único del vuelo.
     *
     * @param id El identificador único del vuelo.
     */
    public void setId(long id) 
    {
        this.id = id;
    }

    /**
     * Obtiene la compañía del vuelo.
     *
     * @return La compañía del vuelo.
     */
    public String getCompany() 
    {
        return company;
    }

    /**
     * Establece la compañía del vuelo.
     *
     * @param company La compañía del vuelo.
     */
    public void setCompany(String company) 
    {
        this.company = company;
    }

    /**
     * Obtiene la fecha y hora del vuelo.
     *
     * @return La fecha y hora del vuelo.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Establece la fecha y hora del vuelo.
     *
     * @param date La fecha y hora del vuelo.
     */
    public void setDate(LocalDateTime date) 
    {
        this.date = date;
    }

    /**
     * Obtiene el precio del vuelo.
     *
     * @return El precio del vuelo.
     */
    public double getPrice() 
    {
        return price;
    }

    /**
     * Establece el precio del vuelo.
     *
     * @param price El precio del vuelo.
     */
    public void setPrice(double price) 
    {
        this.price = price;
    }

    /**
     * Obtiene el número de asientos disponibles en el vuelo.
     *
     * @return El número de asientos disponibles en el vuelo.
     */
    public int getAvailableSeats() 
    {
        return availableSeats;
    }

    /**
     * Establece el número de asientos disponibles en el vuelo.
     *
     * @param availableSeats El número de asientos disponibles en el vuelo.
     */
    public void setAvailableSeats(int availableSeats) 
    {
        this.availableSeats = availableSeats;
    }

    /**
     * Devuelve una representación en cadena de texto formateada del objeto Flight.
     *
     * @return Una cadena de texto que representa de manera formateada el objeto Flight.
     */
    @Override
    public String toString() 
    {
        return "Flight [id=" + id + ", company=" + company + ", date=" + date + ", price=" + price + ", availableSeats="
                + availableSeats + "]";
    }

    /**
     * Calcula y devuelve un valor hash único para este objeto Flight basado en su identificador único.
     *
     * @return El valor hash del objeto Flight.
     */
    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }

    /**
     * Compara este objeto Flight con otro objeto para determinar si son iguales.
     *
     * @param obj El objeto a comparar con este Flight.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Flight other = (Flight) obj;

        if (id != other.id)
            return false;

        if (company == null) 
        {
            if (other.company != null)
                return false;
        } 
        else if (!company.equals(other.company))
        {
            return false;
        } 
        if (date == null) 
        {
            if (other.date != null)
                return false;
        } 
        else if (!date.equals(other.date))
            return false;

        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;

        if (availableSeats != other.availableSeats)
            return false;

        return true;
    }
}

