import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ApplemanAndCardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line1 = sc.nextLine().split("\\s+");
        int k = Integer.parseInt(line1[1]);

        char[] letters = sc.nextLine().toCharArray();

        HashMap<Character, Integer> letterToCount = new HashMap<>();

        for (char c : letters) {
            int newCount = letterToCount.getOrDefault(c, 0) + 1;
            letterToCount.put(c, newCount);
        }

        List<Character> sortedLettters = new ArrayList<>();
        for (char c : letterToCount.keySet()) {
            sortedLettters.add(c);
        }
        Collections.sort(sortedLettters, (a, b) -> letterToCount.get(b) - letterToCount.get(a));
        
        int spaceLeft = k;
        int letterIndex = 0;

        long result = 0;

        while (spaceLeft > 0 && letterIndex < sortedLettters.size()) {

            // A -> 10, B -> 5
            // [ _, _, _, _ ]

            char currLetter = sortedLettters.get(letterIndex);
            int letterCount = letterToCount.get(currLetter);

            int toFill = Math.min(spaceLeft, letterCount);
            spaceLeft -= toFill;

            double toAdd = Math.pow(toFill, 2);
            result += toAdd;

            letterIndex++;
        }

        System.out.print(result);
        sc.close();
    }
    
}
