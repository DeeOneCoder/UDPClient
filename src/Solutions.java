import java.io.*;

import java.util.*;

import java.util.stream.*;


import static java.util.stream.Collectors.toList;


public class Solutions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        printMax(arr);
    }

    public static void printMax(List<List<Integer>> arr) {

        //Variable to hold the total values of each hour glass
        List<Integer> hourGlassSums = new ArrayList<>();

        /**
         * This will loop through the arr argument and pick three
         * rows at a time; i will increase till it reaches 3 - index 4
         */
        int arrayLength = arr.size();
        for (int i = 0; i < (arrayLength - 2); i++) {
            List<Integer> list = arr.get(i);
            List<Integer> list1 = arr.get(i + 1);
            List<Integer> list2 = arr.get(i + 2);

            /** We'll start moving across the lists picking the required columns
             * This columnCount will stop when it reaches 3 - index 4.
             */
            int columnCount = 0;
            while (columnCount < list.size() - 2) {
                int total = 0;
                int start = columnCount;
                int end = columnCount + 2;
                int mid = (start + end) / 2;

                /** Loop to extract integer values and save into total variable.
                 * Note the total variable was created inside the loop
                 */
                for (int x = start; x <= end; x++) {
                    total += list.get(x);
                    total += list2.get(x);
                }
                total += list1.get(mid);

                /** Update hourGlassSums with the value of the hour glass
                 */
                hourGlassSums.add(total);

                columnCount++;
            }
        }

        /** Loop through the hourGlassSums variable
         * to extract the maximum
         */
        int max = Integer.MIN_VALUE;
        for (int x : hourGlassSums) {
            if (x > max) {
                max = x;
            }
        }

        System.out.println(max);


    }
}
