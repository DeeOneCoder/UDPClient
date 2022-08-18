import java.io.*;
import java.util.*;

public class Solution4 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        int numOfIntegers = scanner.nextInt();
        scanner.nextLine();

        String[] intArray = scanner.nextLine().split(" ");

        for (int i = 0; i < numOfIntegers; i++) {
            int j = Integer.parseInt(intArray[i]);
            list.add(j);
        }
        int numOfQuery = scanner.nextInt();
        scanner.nextLine();

        while (numOfQuery > 0) {
            String query = scanner.nextLine();

            String q = scanner.nextLine();

            if (query.equals("Insert")) {
                String[] inserts = q.split(" ");
                int x = Integer.parseInt(inserts[0]);
                int y = Integer.parseInt(inserts[1]);

                list.add(x, y);
            }

            if (query.equals("Delete")) {
                int x = Integer.parseInt(q);
                list.remove(x);
            }
            numOfQuery--;
        }

        for (int y : list) {
            System.out.print(y + " ");
        }

        scanner.close();
    }
}