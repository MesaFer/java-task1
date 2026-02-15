import java.time.LocalDateTime;

public class BankAccount {
    private String owner;
    private int balance;
    private LocalDateTime createdAt;
    private boolean isBlocked;
    private String messageBlock;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
        this.createdAt = LocalDateTime.now();
        this.isBlocked = false;
        this.messageBlock = "Аккаунт заблокирован.";
    }

    public String greet() {
        return "Hello, " + owner + "! Your balance is $" + balance + ". Created on " + createdAt + ". Is blocked: " + isBlocked + ".";
    }

    public void deposit(int amount) {
        if (!isBlocked) {
            balance += amount;
        }else{
            System.out.println(messageBlock);
        }
    }

    public void withdraw(int amount) {
        if (!isBlocked && balance >= amount) {
            balance -= amount;
        }else if(isBlocked){
            System.out.println(messageBlock);
        }
    }

    public void transfer(BankAccount otherAccount, int amount) {
        if (!isBlocked && balance >= amount) {
            this.withdraw(amount);
            otherAccount.deposit(amount);
        }else if(isBlocked){
            System.out.println(messageBlock);
        }
    }

}
