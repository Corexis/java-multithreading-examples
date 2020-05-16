package synchronlzed;

public class Operations {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(10_000_000);
        System.out.println("begin balance: " + account.getBalance());

        Thread tr1 = new WithDrawThread(account);
        Thread tr2 = new DepositThread(account);

        tr1.start();
        tr2.start();

//        try {
//        // join не позволит строчке 23 отработать раньше, чем tr1 и tr2 завершат свою работу
//            tr1.join();
//            tr2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("End balance: " + account.getBalance());
    }


    private static class WithDrawThread extends Thread {
        private final BankAccount account;

        private WithDrawThread(BankAccount account) {
            this.account = account;
        }


        @Override
        public void run() {
            for (int i = 0; i < 10_000_000; i++) {
                account.withDraw(1);
            }
        }
    }

    public static class DepositThread extends Thread {
        private final BankAccount account;

        public DepositThread(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
