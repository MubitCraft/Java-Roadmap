public class StringDemo {

    public static void main(String[] args) {

        // 1) STRING – immutable  (real world: login form)
        String email = "  Ali.Khan@Gmail.com  ";

        // trim – clean user input
        String clean = email.trim();
        System.out.println("Trimmed: [" + clean + "]");

        // toLowerCase – normalize for comparison
        String lower = clean.toLowerCase();
        System.out.println("Lower: " + lower);

        // contains + endsWith – simple validation
        boolean validEmail = lower.contains("@") && lower.endsWith(".com");
        System.out.println("Valid email? " + validEmail);

        // indexOf + substring – extract username
        int at = clean.indexOf("@");
        String username = clean.substring(0, at);
        System.out.println("Username: " + username);

        // split – parse CSV
        String csv = "apple,banana,mango";
        String[] fruits = csv.split(",");
        System.out.println("Fruits count: " + fruits.length);
        for (String f : fruits) System.out.println(" - " + f);

        // replace – mask sensitive text
        String msg = "My password is 1234";
        System.out.println(msg.replace("1234", "****"));

        // charAt + length – first/last char
        String word = "hello";
        System.out.println("First char: " + word.charAt(0)
                + ", last char: " + word.charAt(word.length() - 1));

        // equals vs ==  (common trap – runs fine, just prints result)
        String a = "java";
        String b = new String("java");
        System.out.println("a == b      : " + (a == b));      // false
        System.out.println("a.equals(b) : " + a.equals(b));  // true

        // 2) STRINGBUILDER – mutable  (real world: receipt)
        StringBuilder sb = new StringBuilder();

        sb.append("Order #").append(101)
          .append(" | Item: Laptop")
          .append(" | Price: $1200");
        System.out.println("\nReceipt: " + sb);

        // insert – add text at front
        sb.insert(0, "[PAID] ");
        System.out.println("After insert: " + sb);

        // delete – remove the tag we just added (7 chars)
        sb.delete(0, 7);
        System.out.println("After delete: " + sb);

        // reverse – palindrome check
        String input = "madam";
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("\n'" + input + "' palindrome? " + input.equals(reversed));

        // toString – StringBuilder -> String
        String finalText = sb.toString();
        System.out.println("Final text length: " + finalText.length());
    }
}
