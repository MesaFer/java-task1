public class main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Kirill");
        BankAccount account2 = new BankAccount("Ivan");

        account1.deposit(1000);
        account2.deposit(500);
        account1.transfer(account2, 200);
        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());


    }
}
