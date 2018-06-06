package terminal;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TerminalTest {

    private TerminalServer server;
    private PinValidator pinValidator;
    private Account account;

    private void setAccToBlocked(Account account, PinValidator pinValidator) throws AccountIsLockedException {

        try {
            pinValidator.validatePin(account, 1487);

        } catch (SecurityException e) {
            try {
                pinValidator.validatePin(account, 1487);
            } catch (SecurityException e1) {
                pinValidator.validatePin(account, 1487);
            }
        }
    }

    @Before
    public void initializeAccount(){
        account = new Account(500, 1488);
        pinValidator = new PinValidator();
        server = new TerminalServer();
    }

    @Test
    public void testTerminalServer(){
        assertEquals(1,1);

    }

    @Test(expected = SecurityException.class)
    public void testValidatePin() throws AccountIsLockedException {
        pinValidator.validatePin(account, 1487);
    }

    @Test(expected = AccountIsLockedException.class)
    public void testAccountIsBlocked() throws AccountIsLockedException {
        setAccToBlocked(account, pinValidator);
    }

    @Ignore
    @Test
    public void testAccessToBlockedAccAfter5sec() throws AccountIsLockedException, InterruptedException {
        Exception ex = null;
        try {
            setAccToBlocked(account, pinValidator);
        } catch (AccountIsLockedException e){
            TimeUnit.SECONDS.sleep(6);
            try {
                pinValidator.validatePin(account, 1488);
            } catch (SecurityException|AccountIsLockedException e1){
                ex = e1;
            }

        }
        assertNull(ex);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInputMultipleBy100(){
        server.putMoney(101,account);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInputGetMoreThenBalance(){
        server.getMoney(501,account);
    }


}
