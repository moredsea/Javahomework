package Practice14;

public class Transaction{
    long money;
    String fromAccountNum;
    String toAccountNum;

    Transaction(long money, String fromAccountNum, String toAccountNum){
        this.money = money;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
    }

    public long getMoney() {
        return money;
    }

    public String getFromAccountNum() {
        return fromAccountNum;
    }

    public String getToAccountNum() {
        return toAccountNum;
    }
}