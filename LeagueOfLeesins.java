import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class LeagueOfLeesins {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        int[][] groups = new int[n - 2][3];
        Map<Integer, Set<Integer>> numToGroupStartIndexes = new HashMap<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < 3; j++) {

                int num = fr.nextInt();
                
                groups[i][j] = num;
                Set<Integer> groupStartIndexes = numToGroupStartIndexes.getOrDefault(num, new HashSet<>());
                groupStartIndexes.add(i);
                numToGroupStartIndexes.put(num, groupStartIndexes);
            }
        }

        int firstNum = -1;
        int[] potentialSecondNums = new int[2];

        for (int num : numToGroupStartIndexes.keySet()) {
            Set<Integer> groupStartIndexes = numToGroupStartIndexes.get(num);
            if (groupStartIndexes.size() == 1) {
                firstNum = num;
                
                for (int startIndex : groupStartIndexes) {

                    int[] group = groups[startIndex];
                    for (int otherNum : group) {

                        if (otherNum == firstNum) {
                            continue;
                        }

                        if (potentialSecondNums[0] == 0) {
                            potentialSecondNums[0] = otherNum;
                        } else {
                            potentialSecondNums[1] = otherNum;
                            break;
                        }

                    }

                }
                break;
            }
        }

        int secondNum = -1;
        int thirdNum = -1;
        if (numToGroupStartIndexes.get(potentialSecondNums[0]).size() == 2) {
            secondNum = potentialSecondNums[0];
            thirdNum = potentialSecondNums[1];
        } else {
            secondNum = potentialSecondNums[1];
            thirdNum = potentialSecondNums[0];
        }

        StringBuilder result = new StringBuilder();
        result.append(firstNum + " " + secondNum + " " + thirdNum);

        int last = firstNum;
        int secondLast = secondNum;
        int thirdLast = thirdNum;

        for (int i = 3; i < n; i++) {

            int currNum = findNext(last, secondLast, thirdLast, groups, numToGroupStartIndexes);
            result.append(" " + currNum);
            
            last = secondLast;
            secondLast = thirdLast;
            thirdLast = currNum;

        }
        
        System.out.println(result.toString());
        

    }

    static int findNext(int last, int secondLast, int thirdLast, int[][] groups, Map<Integer, Set<Integer>> numToGroupStartIndexes) {

        List<Set<Integer>> groupStartIndexesSets = Arrays.asList(numToGroupStartIndexes.get(secondLast), numToGroupStartIndexes.get(thirdLast));

        for (Set<Integer> groupStartIndexes : groupStartIndexesSets) {

            for (int startIndex : groupStartIndexes) {

                int[] group = groups[startIndex];
                int containsCount = 0;
                for (int num : group) {
                    if (num == last) {
                        containsCount -= 5;
                        break;
                    }
                    if (num == secondLast || thirdLast == num) {
                        containsCount++;
                    }
                }

                if (containsCount == 2) {

                    for (int num : group) {
                        if (num == secondLast || thirdLast == num) {
                            continue;
                        }
                        return num;
                    }

                }

            }

        }




        return -1;
    }


    /** HELPER */

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        int[] nextLineAsIntArray(int n) {
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[i] = nextInt();
            }
            return result;
        }

        long[] nextLineAsLongArray(int n) {
            long[] result = new long[n];

            for (int i = 0; i < n; i++) {
                result[i] = nextLong();
            }

            return result;
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
