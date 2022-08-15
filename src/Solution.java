import java.util.*;

class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            String checker = sc.next();
            String input = checker.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");
            while (input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length()) ;
            System.out.println(input.isEmpty());
            //          isBalanced(input);
        }

    }

    private static void isBalanced(String check) {

        boolean flag = sequenceCheck(check);
        boolean flag1 = anagramCheck(check);

        if (flag || flag1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    private static boolean sequenceCheck(String check) {

        if (check.length() == 0) {
            return true;
        }

        if (check.length() % 2 == 1) {
            return false;
        }

        String pattern = "(){}[]";
        String a = "()";
        String b = "{}";
        String c = "[]";


        int start1 = 0;
        int mid = check.length() / 2;

        boolean flag1 = false;

        for (int k = 0; k < mid; k++) {
            String immediate = "" + check.charAt(start1) + check.charAt(start1 + 1);

            for (int j = 0; j < pattern.length() - 1; j += 2) {

                String checkingPattern = pattern.substring(j, j + 2);
                //System.out.println(checkingPattern);

                if (immediate.equals(a) || immediate.equals(b) || immediate.equals(c)) {
                    start1 += 2;
                    flag1 = true;
                    break;
                } else {
                    start1 += 2;
                    flag1 = false;
                    return false;
                }

            }


        }
        return flag1;
    }

    private static boolean anagramCheck(String check) {
        boolean flag = false;

        if (check.length() == 0) {
            return true;
        }

        if (check.length() % 2 == 1) {
            return false;
        }

        String pattern = "(){}[]";
        String a = "()";
        String b = "{}";
        String c = "[]";

        int start = 0;

        int end = check.length() - 1;
        int mid = check.length() / 2;

        for (int k = 0; k < mid; k++) {
            String endString = "" + check.charAt(start) + check.charAt(end);


            for (int j = 0; j < pattern.length() - 1; j += 2) {

                if (endString.equals(a) || endString.equals(b) || endString.equals(c)) {
                    start++;
                    end--;
                    flag = true;
                    if (sequenceCheck(check.substring(start, end + 1))) {
                        return true;
                    }
                    break;
                } else {
                    return false;
                }


            }

        }

        return flag;

    }
}



