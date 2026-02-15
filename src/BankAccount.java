import java.time.LocalDateTime;

public class BankAccount {
    private static final String MESSAGE_BLOCK = "Аккаунт заблокирован.";

    private String owner;
    private int accountNumber; // XXXXXXXXX
    private int balance;
    private LocalDateTime createdAt;
    private boolean isBlocked;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
        this.accountNumber = (int) (Math.random() * 1000000000);
        this.createdAt = LocalDateTime.now();
        this.isBlocked = false;

    }

    // Делаем геттеры для всех полей, чтобы можно было получить информацию о счете

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    // Теперь можно и методы изменений
    public void blockAccount() {
        this.isBlocked = true;
    }

    public void unblockAccount() {
        this.isBlocked = false;
    }

    public void deposit(int amount) {
        if (!isBlocked) {
            balance += amount;
        }else{
            System.out.println(MESSAGE_BLOCK);
        }
    }

    public void withdraw(int amount) {
        if (!isBlocked && balance >= amount) {
            balance -= amount;
        }else if(isBlocked){
            System.out.println(MESSAGE_BLOCK);
        }else{
            System.out.println("Недостаточно средств для снятия.");
        }
    }

    public void transfer(BankAccount otherAccount, int amount) {
        if (!isBlocked && balance >= amount) {
            this.withdraw(amount);
            otherAccount.deposit(amount);
        }else if(isBlocked){
            System.out.println(MESSAGE_BLOCK);
        }
    }

    public String getInfo() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
