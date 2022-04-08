import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        while (sc.hasNext()) {
            sc.nextLine();
            char[] line = sc.nextLine().toCharArray();
            solve(line);
        }

        // char[] line = "abbacca".toCharArray();
        // solve(line);
        sc.close();

    }

    public static void solve(char[] cs) {

        int[] possibleLengths = new int[]{2, 3, 4, 7};

        for (int length : possibleLengths) {

            if (length > cs.length) {
                break;
            }

            int left = 0;
            int right = 0;
            int[] counts = new int[3];

            while (right - left < length) {
                counts[cs[right] - 'a']++;
                right++;
            }

            if (moreAs(counts)) {
                System.out.println(length);
                return;
            }

            while (right < cs.length) {

                counts[cs[right] - 'a']++;
                right++;

                counts[cs[left] - 'a']--;
                left++;

                if (moreAs(counts)) {
                    System.out.println(length);
                    return;
                }

            }

        }

        System.out.println("-1");

    }

    public static boolean moreAs(int[] counts) {
        return counts[0] > counts[1] && counts[0] > counts[2];
    }
}