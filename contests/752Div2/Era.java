import java.util.Scanner;

public class Era {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {

            int n = sc.nextInt();

            // 1 2 5 7 4
            int noInsertions = 0;

            for (int j = 1; j <= n; j++) {

                int curr = sc.nextInt();
                
                if (j + noInsertions < curr) {
                    noInsertions += curr - (noInsertions + j);
                }

            }

            System.out.println(noInsertions);
            sc.close();
        }
        
    }
    
    
}
