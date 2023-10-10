package src.user;

import java.util.Date;

public class Locker {
    public int lockerNumber;
    public boolean isAvailable;
    public String renterName;
    public Date rentExpirationDate;

    //  Constructor
    public Locker(int lockerNumber, boolean isAvailable, String renterName, Date rentExpirationDate){
        this.lockerNumber = lockerNumber;
        this.isAvailable = isAvailable;
        this.renterName = renterName;
        this.rentExpirationDate = rentExpirationDate;
    }

    //  Getters & Setters
    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(User user){
        
    }

    public Date endRentPeriod(){
        return rentExpirationDate;
    }
}
