import java.util.Arrays;
import java.util.Collections;

public class BinaryInsertionSort {

    public static int[] binaryInsertSort(int[] array) {
        int sideOne = array.length / 2;

        int[] sideA = new int[sideOne];
        int[] sideB = new int[array.length - sideOne];

        for (int i = 0; i < sideOne; i++) {
            sideA[i] = array[i];
        }
        int x = 0;
        for (int j = sideOne; j < array.length; j++) {
            sideB[x++] = array[j];
        }

        Arrays.sort(sideA);
        Arrays.sort(sideB);
        int aStart = 0;
        int bStart = 0;
        int resultIndex = 0;
        int[] result = new int[array.length];


        while (aStart < sideOne && bStart < array.length - sideOne) {


            if (sideA[aStart] < sideB[bStart]) {
                result[resultIndex] = sideA[aStart];
                aStart++;
                resultIndex++;

            } else if (sideA[aStart] > sideB[bStart]) {
                result[resultIndex] = sideB[bStart];
                bStart++;
                resultIndex++;

            } else {

                result[resultIndex] = sideA[aStart];
                resultIndex++;
                result[resultIndex] = sideB[bStart];
                resultIndex++;
                aStart++;
                bStart++;

                if (aStart == sideOne) {
                    --aStart;
                    while (bStart < (array.length - sideOne)) {
                        result[resultIndex] = sideB[bStart];
                        resultIndex++;
                        bStart++;
                    }
                }

                if (bStart == ((array.length - sideOne) - 1)) {
                    --bStart;
                    while (aStart < sideOne) {
                        result[resultIndex] = sideA[aStart];
                        resultIndex++;
                        aStart++;
                    }
                }

            }


        }

        return result;

    }

    public static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 2, 5, 3, 4, 9, 8, 10, 6, 7};
        int[] array2 = {1, 1, 1, 5, 9, 8, 7, 2, 6};

        printArray(binaryInsertSort(array));
        System.out.println("*************");
        printArray(binaryInsertSort(array2));

    }
}
