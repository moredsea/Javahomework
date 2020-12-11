package Practice14;

import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank(HashMap<String, Account> acs){
        accounts = acs;
    }

    public HashMap<String, Account> getAccounts(){
        return accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if(amount>50000 && isFraud(fromAccountNum, toAccountNum, amount)){
            System.out.println("Счета "+fromAccountNum+" и "+toAccountNum+" заблокированы");
            accounts.get(fromAccountNum).setBlocked();
            accounts.get(toAccountNum).setBlocked();
        }
        if(!accounts.get(fromAccountNum).isAccountBlocked() && !accounts.get(toAccountNum).isAccountBlocked()){
            accounts.get(fromAccountNum).changeMoney(-amount);
            accounts.get(toAccountNum).changeMoney(amount);
            System.out.println("Перевод на сумму " + amount+ " со счета " + fromAccountNum + " на счет " + toAccountNum + " успешно совершён" + "\n"
                    + "Баланс счёта " + fromAccountNum+": "+getBalance(fromAccountNum) + "\n" +
                    "Баланс счёта " + toAccountNum+": "+getBalance(toAccountNum));
        } else{
            System.out.println("Перевод на сумму " + amount+ " со счета " + fromAccountNum + " на счет " + toAccountNum + " заблокирован");
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }
}