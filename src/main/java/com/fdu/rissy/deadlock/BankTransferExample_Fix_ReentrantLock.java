package main.java.com.fdu.rissy.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankTransferExample_Fix_ReentrantLock {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(50000);
        BankAccount account2 = new BankAccount(60000);
        BankAccount.initiateTransfer(account1, account2, 1000);
        BankAccount.initiateTransfer(account2, account1, 1000);
    }

    static final class BankAccount {
        private double balanceAmount;
        private final Lock lock = new ReentrantLock();
        private final Random number = new Random(123);

        public BankAccount(double balance) {
            this.balanceAmount = balance;
        }

        private void depositAmount(BankAccount to, double amount) throws InterruptedException{
            while (true) {
                //if 'this' couldn't get 'to' lock, it will release 'this' lock. will avoid deadlock
                if (this.lock.tryLock()) {
                    try {
                        if (to.lock.tryLock()) {
                            try {
                                if (amount > balanceAmount) {
                                    throw new IllegalArgumentException("Transfer can't be completed");
                                }
                                to.balanceAmount += amount;
                                this.balanceAmount -= amount;
                                break;
                            } finally {
                                to.lock.unlock();
                            }
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
                int n = number.nextInt(1000);
                int time = 1000 + n;
                Thread.sleep(time);
            }
        }

        public static void initiateTransfer(final BankAccount first, final BankAccount second, final double amount) {

            Thread transfer = new Thread(() -> {
                try {
                    first.depositAmount(second, amount);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            transfer.start();
        }
    }
}

