public class TeaStallBill {
    public static void main(String[] args) {

        String customer = "Ravi";
        int cups = 3;

        double pricePerCup = 12.5;
        char size = 'M';
        boolean isMember = true;

        double total = cups * pricePerCup;
        boolean bigOrder = cups > 2;
        boolean getsDiscount = isMember && bigOrder;
        double discount = getsDiscount ? total * 0.10 : 0;
        double finalBill = total - discount;

        int roundedBill = (int) finalBill;
        double tax = cups;

        System.out.println("Customer: " + customer);
        System.out.println("Cups: " + cups + " | Size: " + size);
        System.out.println("Total: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Bill: " + finalBill);
        System.out.println("Rounded Bill (int): " + roundedBill);
        System.out.println("Tax base (double): " + tax);
    }
}
