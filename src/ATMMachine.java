public class ATMMachine {
    public static void main(String[] args) {

        greet();
        double bal = checkBalance(5000);
        double newBal = deposit(bal, 2000);
        withdraw(newBal, 1000);

        System.out.println("Bonus 1: " + bonus(500));
        System.out.println("Bonus 2: " + bonus(500, 50));
        System.out.println("Bonus 3: " + bonus(500.0));
    }

    static void greet() {
        System.out.println("Welcome to ATM!");
    }

    static double checkBalance(double balance) {
        return balance;
    }

    static double deposit(double balance, double amount) {
        return balance + amount;
    }

    static void withdraw(double balance, double amount) {
        System.out.println("Withdrew: " + amount);
        System.out.println("Remaining: " + (balance - amount));
    }

    static int bonus(int amount) {
        return amount + 10;
    }

    static int bonus(int amount, int extra) {
        return amount + extra;
    }

    static double bonus(double amount) {
        return amount + 5.5;
    }
}
