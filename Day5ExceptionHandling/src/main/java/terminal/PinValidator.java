package terminal;

import java.time.LocalDateTime;

public class PinValidator {
    public void validatePin(Account account, Integer pincode) throws AccountIsLockedException, SecurityException {

        if (account.isLocked()){
            LocalDateTime nowTime = LocalDateTime.now();
            if (nowTime.getSecond() - account.getBlockedTime().getSecond() >= 5 ){
                account.setLocked(false);
                // попытка ввода пинкода
                tryOfInputPincode(account, pincode);
            } else {
                throw new AccountIsLockedException("Неверный пинкод! Ваш аккаунт все еще заблокирован!");
            }
        } else {
            // попытка ввода пинкода
            tryOfInputPincode(account, pincode);
        }
    }

    public static void tryOfInputPincode(Account account, Integer pincode) throws AccountIsLockedException {
        if (!account.getPincode().equals(pincode)){
            account.setNumberOfTries(account.getNumberOfTries() + 1);
            if (account.getNumberOfTries() >= 3){
                account.setLocked(true);
                LocalDateTime currentTime = LocalDateTime.now();
                account.setBlockedTime(currentTime);
                throw new AccountIsLockedException("Неверный пинкод! Ваш Аккаунт был заблокирован!");
            }
            throw new SecurityException("Неверный пинкод!");
        }
        account.setNumberOfTries(0);
    }
}