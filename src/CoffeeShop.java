public class CoffeeShop {
    public static void main(String[] args) {

        System.out.println("--- Making coffee ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Cup " + i + " ready");
        }

        System.out.println("--- Stock check ---");
        int stock = 3;
        while (stock > 0) {
            System.out.println("Stock left: " + stock);
            stock--;
        }
        System.out.println("Out of stock!");

        System.out.println("--- Menu ---");
        int order = 1;
        do {
            System.out.println("Serving order #" + order);
            order++;
        } while (order <= 3);

        System.out.println("--- Receipt border ---");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
