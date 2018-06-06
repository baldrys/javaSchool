package terminal;

public class TerminalServer {


    public void getMoney(Integer money, Account account) {
        Integer balance = account.getBalance();
        if (money % 100 == 0){
            if (balance >= money){
                account.setBalance(balance-money);
            } else {
                throw new IllegalArgumentException("Нельзя снять больше денег чем есть на счете!");

            }
        } else {
            throw new IllegalArgumentException("Сумма должна быть кратна 100р");
        }
    }

    public void putMoney(Integer money, Account account) {

        if (money % 100 == 0){
            account.setBalance(account.getBalance()+money);
        } else {
            throw new IllegalArgumentException("Сумма должна быть кратна 100р");
        }

    }

    public int checkBalance(Account account) {
        return account.getBalance();
    }

}
