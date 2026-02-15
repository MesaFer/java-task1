import java.time.LocalDateTime;
import java.util.Objects;

public class BankAccount {
    private static final String MESSAGE_BLOCK = "Аккаунт заблокирован.";

    private String owner;
    private int accountNumber; // XXXXXXXX
    private int balance;
    private LocalDateTime createdAt;
    private boolean isBlocked;

    public BankAccount(String owner) {
        this.owner = owner;
        this.balance = 0;
        this.accountNumber = (int) (Math.random() * 100000000); // 8 цифр: 00000000–99999999
        this.createdAt = LocalDateTime.now();
        this.isBlocked = false;
    }

    // Геттеры

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

    // Методы управления блокировкой

    public void blockAccount() {
        this.isBlocked = true;
    }

    public void unblockAccount() {
        this.isBlocked = false;
    }

    // Методы операций (возвращают boolean — успешно или нет)

    public boolean deposit(int amount) {
        if (!isBlocked && amount > 0) {
            balance += amount;
            return true;
        }
        if (isBlocked) {
            System.out.println(MESSAGE_BLOCK);
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if (!isBlocked && balance >= amount && amount > 0) {
            balance -= amount;
            return true;
        }
        if (isBlocked) {
            System.out.println(MESSAGE_BLOCK);
        } else {
            System.out.println("Недостаточно средств для снятия.");
        }
        return false;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (!isBlocked && !otherAccount.isBlocked && balance >= amount && amount > 0) {
            balance -= amount;
            otherAccount.balance += amount;
            return true;
        }
        if (isBlocked) {
            System.out.println(MESSAGE_BLOCK);
        }
        return false;
    }

    // equals и hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber
                && balance == that.balance
                && isBlocked == that.isBlocked
                && Objects.equals(owner, that.owner)
                && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, accountNumber, balance, createdAt, isBlocked);
    }

    // toString вместо getInfo (доп. задание 1)

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", accountNumber=" + String.format("%08d", accountNumber) +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
