package terminal;

public class TerminalImpl implements Terminal {
    private TerminalServer server;
    private PinValidator pinValidator;
    private Account account;

    public TerminalImpl(Account account) {
        this.account = account;
        this.pinValidator = new PinValidator();
        this.server = new TerminalServer();
    }

    @Override
    public String checkBalance(Integer pincode) {

        try {
            pinValidator.validatePin(account, pincode);
            return "Ваш баланс: " + String.valueOf(server.checkBalance(account));
        } catch (SecurityException | AccountIsLockedException e) {
            return e.getMessage();
        }
    }

    @Override
    public String getMoney(Integer money, Integer pincode) {

        try {
            pinValidator.validatePin(account, pincode);
            server.getMoney(money, account);
            return String.format("С ващего счета было списано %d.", money);
        } catch (IllegalArgumentException|SecurityException|AccountIsLockedException e){
            return "Неудалось ссписать деньги со счета. " + e.getMessage();
        }
    }

    @Override
    public String putMoney(Integer money, Integer pincode) {
        try {
            pinValidator.validatePin(account, pincode);
            server.putMoney(money, account);
            return String.format("Успешно пополнен баланс, на сумму: %d.", money);
        } catch (IllegalArgumentException|SecurityException|AccountIsLockedException e){
            return "Неудалось пополнить счет. " + e.getMessage();
        }
    }

}
