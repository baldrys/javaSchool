package terminal;

public interface Terminal {
    String checkBalance(Integer pincode);

    String getMoney(Integer money, Integer pincode);

    String putMoney(Integer money, Integer pincode);
}
