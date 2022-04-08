import java.util.LinkedList;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0 0 0 1 0 0 0 0 1
        // 00110011010101110000000

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            char[] tc = parseTestCase(sc.nextLine());
            solve(tc);
        }

        sc.close();
        // char[] tc = parseTestCase("00110011010101110000000");
        // solve(tc);

    }

    public static void solve(char[] tc) {
        // 0 1 0 1 0 1 0 1 1 1 1 1 0 0 0 0
        int left = 0;
        int right = tc.length - 1;

        LinkedList<Integer> leftIndicies = new LinkedList<>();
        LinkedList<Integer> rightIndicies = new LinkedList<>();

        // 00100
        //    l   
        //    r

        // rI = 5
        // lI =  

        while (right > left) {
            
            // System.out.println("l: " + left + " r: " + right);
            // System.out.println("tc[] l: " + tc[left] + " r: " + tc[right]);

            while (right > left && tc[right] != '0') {
                right--;
            }

            if (right == left) { // can not move anymore
                printSolution(leftIndicies, rightIndicies); // TODO
                return;
            }

            
            while (tc[left] != '1' && left < right) {
                left++;
            }

            if (left < right){
                rightIndicies.addFirst(right);
                leftIndicies.addLast(left);
            }

            left++;
            right--;

        }

        printSolution(leftIndicies, rightIndicies);

    }

    public static void printSolution(LinkedList<Integer> left, LinkedList<Integer> right) {

        if (left.size() == 0 && right.size() == 0) {
            System.out.println("0");    
            return;
        }

        System.out.println("1");
        System.out.print(left.size() + right.size() + " ");
        for (int i : left) {
            System.out.print((i + 1) + " ");
        }
        for (int i : right) {
            System.out.print((i + 1) + " ");
        }
    }

    public static char[] parseTestCase(String s) {

        return s.toCharArray();

    }

    
}