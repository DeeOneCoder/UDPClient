
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }

        int count = 0;

        for (int j = 0; j < n; j++) {
            if (array[j] < 0) {
                count++;
            }
        }


        int start = 0;

        while (start < n) {
            int total = 0;
            int newCount = 0;
            for (int x = start; x < n; x++) {

                total += array[x];
                newCount++;
                if (total < 0 && newCount > 1) {
                    count++;
                }
            }
            start++;
        }

        System.out.println(count);

        scanner.close();
    }
}
