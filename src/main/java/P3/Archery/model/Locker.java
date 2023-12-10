package P3.Archery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Document(collection = "lockers")
public class Locker {

    @Id
    private String id;

    public int lockerNumber;
    public boolean isAvailable;
    public User renter;
    public ZonedDateTime rentExpirationDate;

    //  Constructor
    public Locker(int lockerNumber, boolean isAvailable, String renterName, ZonedDateTime rentExpirationDate){
        this.lockerNumber = lockerNumber;
        this.isAvailable = isAvailable;
        this.renter = renter;
        this.rentExpirationDate = rentExpirationDate;
    }

    //  Getters & Setters
    public String getRenterName() {
        return (renter != null) ? renter.getName() : null;
    }

    public void setRenter(User renter){
        this.renter = renter;
    }

    public ZonedDateTime endRentPeriod(){ return rentExpirationDate; }
}
