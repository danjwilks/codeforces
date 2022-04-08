import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Map<String, Integer> nameToCount = new HashMap<>();
        while (sc.hasNext()) {
            String name = sc.nextLine();
            if (nameToCount.containsKey(name)) {
                int previousCount = nameToCount.get(name);
                nameToCount.put(name, previousCount + 1);
                System.out.println(name + previousCount);
            } else {
                nameToCount.put(name, 1);
                System.out.println("OK");
            }
        }
        sc.close();
    }
    
}
