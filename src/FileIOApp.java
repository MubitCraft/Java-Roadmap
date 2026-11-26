import java.io.*;
import java.util.*;

public class FileIOApp {

    static final String FILE = "scores.txt";

    public static void main(String[] args) {

        // A) SHORTEST FILE I/O (write → read)
        try {
            try (BufferedWriter w = new BufferedWriter(new FileWriter("hello.txt"))) {
                w.write("Hello, file!");
            }
            try (BufferedReader r = new BufferedReader(new FileReader("hello.txt"))) {
                System.out.println("Quick demo read: " + r.readLine());
            }
        } catch (IOException e) {
            System.out.println("File demo failed: " + e.getMessage());
        }

        // B) SHORTEST WRAPPER (String → Integer → int)
        Integer boxed   = Integer.parseInt("42");   // parse + autobox
        int     unboxed = boxed;                    // unboxing
        System.out.println("Quick demo wrapper: " + unboxed
                + " (MAX int = " + Integer.MAX_VALUE + ")");

        // C) CONSOLE MINI-APP (score tracker)
        List<Integer> scores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1)Add 2)Stats 3)Save 4)Load 5)Exit");
            System.out.print("> ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    System.out.print("Score: ");
                    try {
                        Integer s = Integer.parseInt(sc.nextLine());   // wrapper parse
                        scores.add(s);                                 // autobox
                        System.out.println("Added " + s);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a number!");
                    }
                    break;
                }
                case "2": {
                    if (scores.isEmpty()) {
                        System.out.println("No scores yet");
                    } else {
                        int max = Integer.MIN_VALUE, sum = 0;
                        for (Integer s : scores) {                     // unboxing
                            max = Integer.max(max, s);
                            sum += s;
                        }
                        System.out.println("Count=" + scores.size()
                                + " Max=" + max
                                + " Avg=" + ((double) sum / scores.size()));
                    }
                    break;
                }
                case "3": {
                    try (BufferedWriter w = new BufferedWriter(new FileWriter(FILE))) {
                        for (Integer s : scores) {
                            w.write(s.toString());                     // wrapper → String
                            w.newLine();
                        }
                        System.out.println("Saved " + scores.size() + " scores");
                    } catch (IOException e) {
                        System.out.println("Save failed: " + e.getMessage());
                    }
                    break;
                }
                case "4": {
                    try (BufferedReader r = new BufferedReader(new FileReader(FILE))) {
                        scores.clear();
                        String line;
                        while ((line = r.readLine()) != null) {
                            scores.add(Integer.valueOf(line.trim()));  // String → Integer
                        }
                        System.out.println("Loaded " + scores.size() + " scores");
                    } catch (IOException e) {
                        System.out.println("Load failed: " + e.getMessage());
                    }
                    break;
                }
                case "5":
                    sc.close();
                    return;
                default:
                    System.out.println("Bad choice");
            }
        }
    }
}
