package Practice14;

import java.util.ArrayList;

class JThread extends Thread {

    Bank bank;
    ArrayList<Transaction> transactions;

    JThread(String name){
        super(name);
    }

    JThread(String name, ArrayList<Transaction> transactions, Bank bank){
        super(name);
        this.transactions = transactions;
        this.bank = bank;
    }





    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        for(int i = 0; i<transactions.size(); i++){
            try {
                bank.transfer(transactions.get(i).getFromAccountNum(), transactions.get(i).getToAccountNum(), transactions.get(i).getMoney());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}