package main.java.com.fdu.rissy.deadlock;

public class BankTransferExample_DeadLock {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(50000);
        BankAccount account2 = new BankAccount(60000);
        BankAccount.initiateTransfer(account1, account2, 1000);
        BankAccount.initiateTransfer(account2, account1, 1000);
    }
    static class BankAccount {
        private double balanceAmount;

        public BankAccount(double balance) {
            this.balanceAmount = balance;
        }

        private void depositAmount(BankAccount to, double amount) {
            //deadlock, when 'to' transfer to 'this'
            synchronized (this) {
                synchronized (to) {
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

