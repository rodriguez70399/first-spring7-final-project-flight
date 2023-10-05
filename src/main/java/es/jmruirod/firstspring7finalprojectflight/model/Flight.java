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

@Entity
@Table(name = "flights")
public class Flight 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company;
    
    /**
     * Fecha y hora en que se realiza el vuelo.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    private double price;
    private int availableSeats;
    
    public Flight() 
    {

    }

    public Flight(String company, LocalDateTime date, double price, int availableSeats) 
    {
        this.company = company;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public Flight(long id, String company, LocalDateTime date, double price, int availableSeats) 
    {
        this.id = id;
        this.company = company;
        this.date = date;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public long getId() 
    {
        return id;
    }

    public void setId(long id) 
    {
        this.id = id;
    }

    public String getCompany() 
    {
        return company;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) 
    {
        this.date = date;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public int getAvailableSeats() 
    {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) 
    {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() 
    {
        return "Flight [id=" + id + ", company=" + company + ", date=" + date + ", price=" + price + ", availableSeats="
                + availableSeats + "]";
    }

    @Override
    public int hashCode() 
    {
        return Objects.hashCode(id);
    }

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
            return false;

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