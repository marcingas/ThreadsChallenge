public class Main {
    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000);
        Thread trThread1 = new Thread() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        };
        Thread trThread2 = new Thread() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        };
        trThread1.start();
        trThread2.start();
    }
}