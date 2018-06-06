package terminal;

import java.time.LocalDateTime;

public class Account {

    private Integer balance;
    private Integer pincode;
    private boolean isLocked;
    private Integer numberOfTries;

    private LocalDateTime blockedTime;

    public boolean isLocked() {
        return isLocked;
    }

    public Integer getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(Integer numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public LocalDateTime getBlockedTime() {
        return blockedTime;
    }

    public void setBlockedTime(LocalDateTime blockedTime) {
        this.blockedTime = blockedTime;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Account(Integer balance, Integer pincode) {
        this.balance = balance;
        this.pincode = pincode;
        this.isLocked = false;
        this.numberOfTries = 0;
        this.blockedTime = null;
    }


    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
