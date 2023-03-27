import java.util.concurrent.TimeUnit;
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
         boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status= true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock ");
            }
        } catch (InterruptedException ie) {
        }
        System.out.println("Deposit transaction status = " + status);
    }

    //alternative way if there is more code
    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock ");
            }
        } catch (InterruptedException ie) {
        }
        System.out.println("Withdrawal transaction status = " + status);
    }

    public void printAccountNumber() {
        System.out.println("Account nr = " + accountNumber);
    }
}