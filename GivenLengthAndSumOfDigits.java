import java.util.Scanner;

public class GivenLengthAndSumOfDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int s = sc.nextInt();

        String noSolution = "-1 -1";
        sc.close();

        if (s == 0) {
            if (m == 1) {
                System.out.println("0 0");
            } else {
                System.out.println(noSolution);
            }
            return;
        }

        // m, s
        // n = am * 10^k + am-1 * 10^k-1 + ... + a1
        // 
        // am + am-1 + ... + a1 = s
        // maximise n
        // 
        //  solution:
        //      from the sum, take the maximum number away
        //      s.t. sum >= 0 and number taken away is < 10
        //      (sum - x >= 0 && x < 10).
        //      
        //      

        // s != 0
        // m != 1

        StringBuilder largest = getLargest(m, s);
        String largestResult = largest.toString();
        if (largest.length() == 0) {
            System.out.println(noSolution);
            return;
        }
        StringBuilder smallest = getSmallest(largest);
        if (smallest.length() == 0) {
            System.out.println(noSolution);
            return;
        }

        System.out.print(smallest.toString() + " " + largestResult);


    }

    public static StringBuilder getSmallest(StringBuilder largest) {
        
        // largest == 9999900000
        // smallest = 1000089999
        if (largest.charAt(largest.length() - 1) != '0') {
            return largest.reverse();
        }

        int firstZeroDigitIndex = 0;
        while (largest.charAt(firstZeroDigitIndex) != '0') {
            firstZeroDigitIndex++;
        }

        int lastNonZeroDigitIndex = firstZeroDigitIndex - 1;
        int oldDigit = largest.charAt(lastNonZeroDigitIndex) - '0';
        int newDigit = oldDigit - 1;
        char newDigitChar = (char) (newDigit + '0');

        

        largest.setCharAt(lastNonZeroDigitIndex, newDigitChar);
        
        largest.setCharAt(largest.length() - 1, '1');
        
        return largest.reverse();

    }

    public static StringBuilder getLargest(int m, int s) {

        StringBuilder largest = new StringBuilder();
        
        while (s > 0 && largest.length() < m) {
            int digit = s < 10 ? s : 9;
            largest.append(digit);
            s -= digit;
        }

        // largest.length == m OR s == 0

        if (largest.length() == m && s != 0) {
            return new StringBuilder();
        }

        if (largest.length() != m) {
            for (int i = largest.length(); i < m; i++) {
                largest.append(0);
            }
        }

        return largest;

    }
}
