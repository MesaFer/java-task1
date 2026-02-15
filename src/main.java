public class main {
    public static void main(String[] args) {
        // Создаём счета
        BankAccount account1 = new BankAccount("Kirill");
        BankAccount account2 = new BankAccount("Ivan");

        // --- Проверка deposit (возвращает boolean) ---
        System.out.println("=== Пополнение счетов ===");
        System.out.println("deposit 1000 для Kirill: " + account1.deposit(1000));
        System.out.println("deposit 500 для Ivan: " + account2.deposit(500));
        System.out.println(account1);
        System.out.println(account2);

        // --- Проверка перевода (возвращает boolean) ---
        System.out.println("\n=== Перевод 200 от Kirill к Ivan ===");
        System.out.println("transfer: " + account1.transfer(account2, 200));
        System.out.println(account1);
        System.out.println(account2);

        // --- Проверка снятия (возвращает boolean) ---
        System.out.println("\n=== Снятие 100 у Ivan ===");
        System.out.println("withdraw: " + account2.withdraw(100));
        System.out.println(account2);

        // --- Проверка снятия больше, чем есть ---
        System.out.println("\n=== Попытка снять 999999 у Ivan ===");
        System.out.println("withdraw: " + account2.withdraw(999999));

        // --- Проверка блокировки ---
        System.out.println("\n=== Блокировка счёта Kirill ===");
        account1.blockAccount();
        System.out.println("isBlocked: " + account1.isBlocked());

        System.out.println("Попытка пополнить заблокированный счёт:");
        System.out.println("deposit: " + account1.deposit(500));

        System.out.println("Попытка снять с заблокированного счёта:");
        System.out.println("withdraw: " + account1.withdraw(100));

        System.out.println("Попытка перевести с заблокированного счёта:");
        System.out.println("transfer: " + account1.transfer(account2, 100));

        // --- Разблокировка ---
        System.out.println("\n=== Разблокировка счёта Kirill ===");
        account1.unblockAccount();
        System.out.println("deposit: " + account1.deposit(500));
        System.out.println(account1);

        // --- Проверка equals ---
        System.out.println("\n=== Проверка equals ===");
        System.out.println("account1.equals(account2): " + account1.equals(account2));
        System.out.println("account1.equals(account1): " + account1.equals(account1));
        System.out.println("account1.equals(null): " + account1.equals(null));
        System.out.println("account1.equals(\"строка\"): " + account1.equals("строка"));

        // --- Проверка hashCode ---
        System.out.println("\n=== Проверка hashCode ===");
        System.out.println("account1.hashCode(): " + account1.hashCode());
        System.out.println("account2.hashCode(): " + account2.hashCode());
        System.out.println("Хэши равны: " + (account1.hashCode() == account2.hashCode()));
    }
}
