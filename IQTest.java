import java.util.Scanner;

public class IQTest {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        String[] line = sc.nextLine().split("\\s+");

        int solution = -1;
        boolean majorityEven = determineMajorityEven(line);
        for (int i = 0; i < line.length; i++) {
            
            if (majorityEven && Integer.parseInt(line[i]) % 2 != 0) {
                solution = i;
                break;
            } if (!majorityEven && Integer.parseInt(line[i]) % 2 == 0) {
                solution = i;
                break;
            }
            
        }
        sc.close();

        System.out.println(solution + 1);

    }

    public static boolean determineMajorityEven(String[] line) {
        int evenCount = 0;

        for (int i = 0; i < 3; i++) {
            evenCount = Integer.parseInt(line[i]) % 2 == 0 ? evenCount + 1 : evenCount;
        }

        return evenCount > 1;

    }
    
}
