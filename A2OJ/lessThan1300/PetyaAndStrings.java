import java.util.Scanner;

public class PetyaAndStrings {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        sc.close();

        for (int i = 0; i < s1.length(); i++) {

            char c1 = Character.toLowerCase(s1.charAt(i));
            char c2 = Character.toLowerCase(s2.charAt(i));

            if (c1 < c2) {
                System.out.println("-1");
                return;
            } else if (c1 > c2) {
                System.out.println("1");
                return;
            }

        }

        System.out.println("0");

    }

}
