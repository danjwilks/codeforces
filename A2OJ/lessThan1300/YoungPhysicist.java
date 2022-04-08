import java.util.Scanner;

public class YoungPhysicist {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int xSum = 0;
        int ySum = 0;
        int zSum = 0;
        int noLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < noLines; i++) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split("\\s");
            xSum += Integer.parseInt(lineSplit[0]);
            ySum += Integer.parseInt(lineSplit[1]);
            zSum += Integer.parseInt(lineSplit[2]);
        }

        scanner.close();

        if (xSum == 0 && ySum == 0 && zSum == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        

    }


}