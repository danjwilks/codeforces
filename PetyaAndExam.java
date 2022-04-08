import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PetyaAndExam {
    public static void main(String[] args) {
        
        FastReader fr = new FastReader();
        StringBuilder result = new StringBuilder();
        int m = fr.nextInt();

        for (int testCase = 0; testCase < m; testCase++) {

            int n = fr.nextInt();
            int T = fr.nextInt();
            long a = fr.nextLong();
            long b = fr.nextLong();

            int[] difficulties = fr.nextLineAsIntArray(n);
            long[] deadlines = fr.nextLineAsLongArray(n);

            long solution = solve(n, T, a, b, difficulties, deadlines);
            result.append(solution + "\n");
  
        }

        System.out.println(result.toString());


    }


    public static long solve(int n, int T, long a, long b, int[] difficulties, long[] deadlines) {

        // instead of iterating from 0 to last deadline,
        // we can iterate through the deadlines and use the deadline minus one
        // this way we can fit the maximum number of problems within that timeframe.
        // e.g.
        //          0 1 2 3 4 5 = timeline
        //      say there is a deadline only at 4.
        //          it is a fact that the number of problems solved by 1, is equal to or 
        //          less than equal to the number of problems solved by 2 and so on
        //          up until deadline minus 1 = 3
        //
        // find the next deadline
        // minus one from the deadline
        // determine the time we have to solve problems
        //      deadline - 1 - (timeMustSpend on previous problems)
        // update timeMustSpend

        Problem[] problems = new Problem[n];
        int easyProblemsToSolve = 0;
        int hardProblemsToSolve = 0;

        for (int i = 0; i < n; i++) {
            problems[i] = new Problem(difficulties[i], deadlines[i]);
            if (problems[i].difficulty == 0) {
                easyProblemsToSolve++;
            } else {
                hardProblemsToSolve++;
            }
        }

        Arrays.sort(problems, (i, j) -> Long.compare(i.deadline, j.deadline));

        long maximumTimeSpent = easyProblemsToSolve * a + hardProblemsToSolve * b;
        if (maximumTimeSpent <= T) {
            return n;
        }

        long maximumProblemsSolved = 0;
        long timeMustSpend = 0;
        int problemIndex = 0;

        while (problemIndex < n) {

            Problem p = problems[problemIndex];
            long selfImposedDeadline = p.deadline - 1;
            
            long timeLeftToSolveNewProblems = selfImposedDeadline - timeMustSpend;

            if (timeLeftToSolveNewProblems >= 0) {

                long numberOfProblemsAlreadySolved = problemIndex;

                long numberOfEasyProblemsCanSolve = Math.min(timeLeftToSolveNewProblems / a, easyProblemsToSolve);
                timeLeftToSolveNewProblems -= numberOfEasyProblemsCanSolve * a;

                long numberOfHardProblemsCanSolve = Math.min(timeLeftToSolveNewProblems / b, hardProblemsToSolve);
                timeLeftToSolveNewProblems -= numberOfHardProblemsCanSolve * b;

                maximumProblemsSolved = Math.max(
                    numberOfProblemsAlreadySolved + numberOfEasyProblemsCanSolve + numberOfHardProblemsCanSolve, 
                    maximumProblemsSolved
                );

            }
    
                // update timeMustSpend
                
            do {
                
                if (problems[problemIndex].difficulty == 0) {
                    easyProblemsToSolve--;
                    timeMustSpend += a;
                    
                } else {
                    hardProblemsToSolve--;
                    timeMustSpend += b;
                }
                
                problemIndex++;

            } while ((problemIndex < n && problems[problemIndex].deadline == p.deadline));

            }
        
        return maximumProblemsSolved;
    
            // 10
            // n = 3
            // T = 5
            // a = 1
            // b = 3

            // 0 0 1 = difficulty
            // 2 1 4 = deadlines
            // 
            // if we start at the right end
            // e.g. we know that the problem must be completed 3 points before hand.

            // we can iterate through the ending times.
            // this will add some constraints

            // if we know we finish at time 0, then we will get 0 points
            // if we stop at 1, then what must we have completed?
            //      task 2, answer is 1
            //
            // if we stop at 2, then we must have completed task 2 and task 1
            //  does this time fit in? If so, we have 2 points worth.
            //      then, see what other problems we can fit in.
            // then go onto the next
    
                
    
    }
    
    


    static class Problem {
        int difficulty;
        long deadline;
        Problem(int difficulty, long deadline) {
            this.difficulty = difficulty;
            this.deadline = deadline;
        }
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
