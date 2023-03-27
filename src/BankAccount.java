import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount extends ReentrantLock {

    private double balance;
    private String accountNumber;
    private Lock lock;



    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
       lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }



    }
//alternative way if there is more code
    public void withdraw(double amount) {
        try{
            balance -= amount;
        }finally {
            lock.unlock();
        }

    }
    public void printAccountNumber(){
        System.out.println("Account nr = " + accountNumber);
    }
}