public class ArrayDemo {

    public static void main(String[] args) {

        // 1D ARRAY  ->  Daily Steps (Mon–Fri)
        int[] steps = {4200, 7800, 5100, 9600, 6300};

        // 1) TRAVERSAL – visit every element
        int total = 0;
        for (int i = 0; i < steps.length; i++) {
            total += steps[i];
        }
        System.out.println("Total steps: " + total);

        // 2) SEARCHING – find a value
        int target = 9600;
        for (int i = 0; i < steps.length; i++) {
            if (steps[i] == target) {
                System.out.println(target + " found at index " + i);
                break;
            }
        }

        // 3) UPDATE – change one value
        steps[0] = 5000;
        System.out.print("Updated steps: ");
        for (int s : steps) System.out.print(s + " ");
        System.out.println("\n");

        // 2D ARRAY  ->  Cinema Seats (0 = free, 1 = booked)
        int[][] seats = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };

        // 1) TRAVERSAL – print the grid
        System.out.println("Seat map:");
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                System.out.print(seats[r][c] + " ");
            }
            System.out.println();
        }

        // 2) SEARCHING – first free seat
        int freeRow = -1, freeCol = -1;
        outer:
        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                if (seats[r][c] == 0) {
                    freeRow = r;
                    freeCol = c;
                    break outer;   // labelled break = exit both loops
                }
            }
        }
        System.out.println("First free seat: (" + freeRow + ", " + freeCol + ")");

        // 3) UPDATE – book that seat
        seats[freeRow][freeCol] = 1;
        System.out.println("After booking:");
        for (int[] row : seats) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
}
