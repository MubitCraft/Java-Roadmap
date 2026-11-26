public class RecursionDemo {

    // helper: returns n levels of indentation to show call-stack depth
    static String pad(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("  ");
        return sb.toString();
    }

    // 1) COUNTDOWN – simplest recursion
    static void countdown(int n) {
        if (n == 0) {                 // BASE CASE
            System.out.println("Liftoff!");
            return;
        }
        System.out.println(n);
        countdown(n - 1);             // RECURSIVE CALL
    }

    // 2) FACTORIAL – visualise push/pop
    static int factorial(int n) {
        System.out.println(pad(4 - n) + "→ factorial(" + n + ")");
        if (n <= 1) {
            System.out.println(pad(4 - n) + "← factorial(1) = 1");
            return 1;
        }
        int result = n * factorial(n - 1);
        System.out.println(pad(4 - n) + "← factorial(" + n + ") = " + result);
        return result;
    }

    // 3) FIBONACCI – two recursive calls
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // 4) REAL-WORLD: nested folder size
    static int folderSize(int level) {
        if (level == 0) return 10;      // smallest file = 10 KB
        return 5 + folderSize(level - 1) + folderSize(level - 1);
    }

    public static void main(String[] args) {

        System.out.println("--- 1) Countdown ---");
        countdown(3);

        System.out.println("\n--- 2) Factorial (stack push & pop) ---");
        System.out.println("Result: " + factorial(4));

        System.out.println("\n--- 3) Fibonacci ---");
        System.out.println("fib(6) = " + fib(6));

        System.out.println("\n--- 4) Nested folder size ---");
        System.out.println("Total KB = " + folderSize(3));
    }
}
