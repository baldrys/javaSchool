package terminal;

public class AccountIsLockedException extends Exception {
    // Parameterless Constructor
    public AccountIsLockedException() {}

    // Constructor that accepts a message
    public AccountIsLockedException(String message) {
        super(message);
    }
}
