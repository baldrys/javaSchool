package terminal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(500, 1488);
        TerminalImpl terminal = new TerminalImpl(account);
        System.out.println(terminal.checkBalance(1487));
        System.out.println(terminal.checkBalance(1487));
        System.out.println(terminal.checkBalance(1487));
//
        System.out.println(terminal.checkBalance(1488));
//
//        TimeUnit.SECONDS.sleep(6);
//        System.out.println(terminal.checkBalance(1488));

        //System.out.println(terminal.getMoney(100, 1488));
//        System.out.println(terminal.checkBalance(1488));
//        System.out.println(terminal.getMoney(1000, 1488));
//        System.out.println(terminal.getMoney(1, 1488));

//        System.out.println(terminal.putMoney(100, 1488));
//        System.out.println(terminal.checkBalance(1488));

    }
}
