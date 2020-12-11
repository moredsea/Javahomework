package Practice14;

public class Account {
    private long money;
    private String accNumber;
    private boolean isBlocked;

    public Account(long money, String accNumber){
        this.accNumber = accNumber;
        this.money = money;
        isBlocked = false;
    }

    public boolean isAccountBlocked() {
        return isBlocked;
    }

    public void setBlocked(){
        isBlocked = true;
    }
    public long getMoney(){
        return money;
    }
    public void changeMoney(long sum){
        money = money + sum;
    }
}
