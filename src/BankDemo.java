public class BankDemo {

    // 4) CUSTOM EXCEPTION – checked (extends Exception)
    static class InsufficientBalanceException extends Exception {
        private final double shortfall;

        InsufficientBalanceException(double shortfall) {
            super("Insufficient balance! Short by: " + shortfall);
            this.shortfall = shortfall;
        }
        double getShortfall() { return shortfall; }
    }

    // 3) THROWS – method admits it can fail (checked one)
    static void withdraw(double balance, double amount)
            throws InsufficientBalanceException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be > 0");   // unchecked
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(amount - balance);  // checked
        }
        System.out.println("Withdrew " + amount + " | Remaining: " + (balance - amount));
    }

    // helper: finally runs even when method returns early
    static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            return -1;
        } finally {
            System.out.println("finally ran (before value is returned)");
        }
    }

    public static void main(String[] args) {

        // 1) TRY-CATCH – catch a specific problem
        System.out.println("=== 1) try-catch ===");
        try {
            int[] seatPrices = {100, 200};
            System.out.println(seatPrices[5]);              // boom
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // 2) TRY-CATCH-FINALLY – cleanup always runs
        System.out.println("\n=== 2) try-catch-finally ===");
        try {
            int divisor = 0;
            int avg = 100 / divisor;                        // boom at runtime
            System.out.println(avg);
        } catch (ArithmeticException e) {
            System.out.println("Caught: division by zero");
        } finally {
            System.out.println("Finally: closing DB connection (ALWAYS runs)");
        }

        // 3) THROWS in action – caller must catch
        System.out.println("\n=== 3) throws (propagate to caller) ===");
        try {
            withdraw(500, 200);                             //   fine
            withdraw(500, 800);                             //   custom exception
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught CUSTOM: " + e.getMessage());
            System.out.println("Shortfall      : " + e.getShortfall());
        } catch (IllegalArgumentException e) {
            System.out.println("Caught ILLEGAL: " + e.getMessage());
        }

        // 4) finally runs even on return
        System.out.println("\n=== 4) finally with return ===");
        System.out.println("Result: " + safeDivide(10, 0));
    }
}
