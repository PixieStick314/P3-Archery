package src.models;

import java.util.Date;

public class Locker {
    public int lockerNumber;
    public boolean isAvailable;
    public User renter;
    public Date rentExpirationDate;

    //  Constructor
    public Locker(int lockerNumber, boolean isAvailable, String renterName, Date rentExpirationDate){
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

    public Date endRentPeriod(){
        return rentExpirationDate;
    }
}
