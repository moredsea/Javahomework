package Practice14;

import java.util.ArrayList;
import java.util.HashMap;



public class Main {


    public static void main(String[] args) {
        HashMap<String, Account> accounts = new HashMap<>();
        accounts.put("1", new Account(1000000, "1"));
        accounts.put("2", new Account(5000000, "2"));
        accounts.put("3", new Account(4000000, "3"));
        accounts.put("4", new Account(1000000, "4"));
        accounts.put("5", new Account(1000000, "5"));

        Bank bank = new Bank(accounts);

        long sum = 0;
        for(String s : bank.getAccounts().keySet()){
            sum+=bank.getAccounts().get(s).getMoney();
        }
        System.out.println("Сумма до транзакций: " + sum);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(5000, "1", "3"));
        transactions.add(new Transaction(70000, "2", "5"));
        transactions.add(new Transaction(600, "5", "3"));
        transactions.add(new Transaction(30000, "1", "4"));
        transactions.add(new Transaction(50000, "1", "5"));
        transactions.add(new Transaction(1000, "3", "2"));
        transactions.add(new Transaction(500, "4", "3"));
        transactions.add(new Transaction(230000, "5", "1"));
        transactions.add(new Transaction(5800, "2", "5"));
        transactions.add(new Transaction(50900, "3", "4"));
        transactions.add(new Transaction(5040, "4", "2"));
        transactions.add(new Transaction(90000, "2", "1"));


        int kolThread = 4;
        int transactionsPerThread = transactions.size()/kolThread;
        int ost = transactions.size() % kolThread;
        int a = transactions.size();

        for(int i=1; i <= kolThread; i++) {
            ArrayList<Transaction> transactionsForSingleThread = new ArrayList<>();
            int k;
            if(ost !=0){
                k = transactionsPerThread + 1;
                ost--;
            } else {
                k = transactionsPerThread;
            }
            for(int j = 0; j < k; j++){
                transactionsForSingleThread.add(transactions.get(transactions.size()-a));
                a--;
            }

            new JThread("JThread " + i, transactionsForSingleThread, bank).start();

        }

    }
}