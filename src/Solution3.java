import java.util.*;

public class Solution3 {

    public static boolean canWin(int leap, int[] game) {
        int n = game.length;

        int i = 0;
        while (i < n) {
            int ch = game[i + 1];
            if (ch == 1) {

                if (game[i + leap] == 0) {
                    return true;
                }

                if ((leap + i) >= n) {
                    return true;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}