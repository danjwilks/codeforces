import java.util.Scanner;

public class SortTheArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] line2 = sc.nextLine().split("\\s+");

        int[] integers = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            integers[i] = Integer.parseInt(line2[i]);
        }

        // 3 1 2 4 5 6
        // we know 3 must move, otherwise, the rest of the list is correct.
        // thus, the maximum we are allowed to swap is just 3 and its adjacent number
        // this is because reversing more will result in an out of order list.

        // 1 2 3 1 2 4 5 6
        // we must swap with all numbers that are smaller with the current number.
        // otherwise there will be a larger number to the left of the numbers to its right
        // thus unsorted

        int segmentStart = 1;
        int segmentEnd = 1;
        
        for (int right = 1; right < integers.length; right++) {

            int left = right - 1;
            if (integers[left] > integers[right]) { // out of order

                int newRightEnd = integers[left];
                
                while (right < integers.length && newRightEnd > integers[right]) {
                    right++;
                }

                segmentEnd = right;
                segmentStart = 1 + left;

                reverse(integers, left, right - 1);
                break;
            }

        }

        if (isSorted(integers)) {
            System.out.println("yes");
            System.out.println(segmentStart + " " + segmentEnd);
        } else {
            System.out.println("no");
        }
        sc.close();
    }

    public static boolean isSorted(int[] integers) {

        for (int i = 1; i < integers.length; i++) {

            if (integers[i - 1] > integers[i]) {
                return false;
            }

        }

        return true;

    }

    public static void reverse(int[] integers, int left, int right) {
        while (right - left > 0) {
            int temp = integers[left];
            integers[left] = integers[right];
            integers[right] = temp;
            left++;
            right--;
        }

    }
    
}
