import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> arrayOfInteger = new ArrayList<>();

        int numberOfInputs = scanner.nextInt();
        scanner.nextLine();

        while (numberOfInputs > 0) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");

            List<Integer> list = new ArrayList<>();
            if (input.equals("0")) {
                list.add(Integer.parseInt(input));
                arrayOfInteger.add(list);
                numberOfInputs--;

            } else {
                for (int i = 0; i < arr.length; i++) {
                    list.add(Integer.parseInt(arr[i]));
                }
                arrayOfInteger.add(list);
                numberOfInputs--;
            }
        }
//        for(List<Integer> list: arrayOfInteger){
//            for(int x: list){
//                System.out.println(x);
//            }
//        }

        int numOfQuery = scanner.nextInt();
        scanner.nextLine();
        String[] query = new String[numOfQuery];
        int j = 0;
        while (numOfQuery > 0) {
            String input = scanner.nextLine();
            query[j] = input;
            numOfQuery--;
            j++;
        }

        for (int i = 0; i < query.length; i++) {

            if (query[i].equals("0")) {
                System.out.println("ERROR!");

            } else {
                String[] in = query[i].split(" ");

                int listRow = Integer.parseInt(in[0]);
                int column = Integer.parseInt(in[1]);


                List<Integer> l1 = arrayOfInteger.get(--listRow);

                if (l1.size() == 1) {
                    System.out.println("ERROR!");
                } else {
                    if (l1.size() > column) {
                        int revert = l1.get(column);
                        System.out.println(revert);
                    } else {
                        System.out.println("ERROR!");
                    }

                }


            }


        }
    }
}