import java.util.Scanner;

public class CafeOrder {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Choose item (1=Tea, 2=Coffee, 3=Juice): ");
        int choice = sc.nextInt();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        if (age < 12) {
            System.out.println("Kids get a free cookie!");
        } else if (age >= 60) {
            System.out.println("Senior discount applied.");
        } else {
            System.out.println("Regular pricing.");
        }

        switch (choice) {
            case 1:
                System.out.println(name + " ordered Tea ($2)");
                break;
            case 2:
                System.out.println(name + " ordered Coffee ($3)");
                break;
            case 3:
                System.out.println(name + " ordered Juice ($4)");
                break;
            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Thank you, " + name + "!");

        sc.close();
    }
}
