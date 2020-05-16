package waitNotify;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withDraw(int amount)  throws InterruptedException  {
        while (balance < amount) {
            wait();
        }
        balance -= amount;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        notifyAll();
    }

    public int getBalance() {
        return balance;
    }
}
