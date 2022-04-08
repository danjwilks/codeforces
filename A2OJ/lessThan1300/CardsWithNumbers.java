import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CardsWithNumbers {

    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        Scanner sc;
        try {
            sc = new Scanner(inputFile);

            int n = Integer.parseInt(sc.nextLine());
            String[] numberStrings = sc.nextLine().split("\\s+");

            HashMap<Integer, Integer> numToIndex = new HashMap<>();
            List<String> result = new ArrayList<>();
            
            for (int i = 0; i < n * 2; i++) {
                
                int currNum = Integer.parseInt(numberStrings[i]);
                
                if (numToIndex.containsKey(currNum)) {
                    result.add((i + 1) + " " + (numToIndex.get(currNum) + 1) );
                    numToIndex.remove(currNum);
                } else {
                    numToIndex.put(currNum, i);
                }
            }

            PrintWriter writer;
            try {
                writer = new PrintWriter("output.txt", "UTF-8");
                if (numToIndex.size() != 0) {
                    writer.print("-1");
                } else {
                    for (String output : result) {
                        writer.println(output);
                    }
                }
                writer.close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}
