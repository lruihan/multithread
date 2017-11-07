package com.fdu.rissy.deadlock;

import java.util.concurrent.atomic.AtomicLong;

public class BankTransferExample_Fix_SameOrder {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(50000);
        BankAccount account2 = new BankAccount(60000);
        BankAccount.initiateTransfer(account1, account2, 1000);
        BankAccount.initiateTransfer(account2, account1, 1000);
    }

    static final class BankAccount implements Comparable<BankAccount>{
        private double balanceAmount;
        private final long id;

        private static final AtomicLong nextID = new AtomicLong(0);

        public BankAccount(double balance) {
            this.balanceAmount = balance;
            this.id = nextID.getAndIncrement();
        }
        @Override
        public int compareTo(BankAccount o) {
            return (this.id > o.id) ? 1 : (this.id < o.id) ? -1 : 0;
        }

        private void depositAmount(BankAccount to, double amount) {
            BankAccount first = this, second = to;
            if(compareTo(to) > 0) {
                first = to;
                second = this;
            }
            synchronized (first) {
                synchronized (second) {
                    if (amount > balanceAmount) {
                        throw new IllegalArgumentException("Transfer can't be completed");
                    }
                    to.balanceAmount += amount;
                    this.balanceAmount -= amount;
                }
            }
        }

        public static void initiateTransfer(final BankAccount first, final BankAccount second, final double amount) {

            Thread transfer = new Thread(() -> {
                first.depositAmount(second, amount);
            });
            transfer.start();
        }

    }
}

