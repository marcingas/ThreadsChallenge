public class Main {
    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000);
        System.out.println("Balance before Threads is: " + account.getBalance());
        Thread trThread1 = new Thread() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
                System.out.println("balance Thread 1  is: " + account.getBalance());
            }
        };
        Thread trThread2 = new Thread() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
                System.out.println("balance Thread 2 is " + account.getBalance());
            }
        };
//        another way of creating Thread using runnable:
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100);
//            }
//        }).start();
        trThread1.start();
        trThread2.start();
    }
}