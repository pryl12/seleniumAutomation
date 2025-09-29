import java.util.Scanner;

public class TransactionProcessor {

    private void processTransaction(Transaction transaction){
        if (transaction.sourceAccount.balance < transaction.transactionAmount) {
            throw new InsufficientFundsException("Insufficient funds in source account: " + transaction.sourceAccount.accountId);
        }
        transaction.sourceAccount.balance -= transaction.transactionAmount;
        transaction.destinationAccount.balance += transaction.transactionAmount;
        System.out.println("Transaction " + transaction.transactionId + " processed: " +
                transaction.transactionAmount + " transferred from " +
                transaction.sourceAccount.accountId + " to " +
                transaction.destinationAccount.accountId);
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        String sourceAccountId = scanner.nextLine();
        double sourceAccountBalance = Double.parseDouble(scanner.nextLine());
        String destionationAccountId = scanner.nextLine();
        double destinationAccountBalance = Double.parseDouble(scanner.nextLine());

        String transactionId = scanner.nextLine();
        double transactionAmount = Double.parseDouble(scanner.nextLine());

        try{
            Account sourceAccount = new Account(sourceAccountId, sourceAccountBalance);
            Account transactionAccount = new Account(destionationAccountId, destinationAccountBalance);
            System.out.println("Account created: " + sourceAccount.accountId + " with balance " + sourceAccount.balance);
            System.out.println("Account created: " + transactionAccount.accountId + " with balance " + transactionAccount.balance);
        }
        catch (Exception e){
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

class Account {
    String accountId;
    double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
}

class Transaction {
    String transactionId;
    Account sourceAccount;
    Account destinationAccount;
    double transactionAmount;

    public Transaction(String transactionId, Account sourceAccount, Account destinationAccount, double transactionAmount) {
        this.transactionId = transactionId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionAmount = transactionAmount;
    }
}

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
