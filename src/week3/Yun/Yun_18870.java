package week3.Yun;

import java.util.Scanner;

public class Yun_18870 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfX = scanner.nextInt();
        scanner.nextLine();

        String[] Xs = scanner.nextLine().split(" ");
        long[] longXs = new long[Xs.length];
        setLongXsFromXs(Xs, longXs);

        int[] answer = new int[longXs.length];
        setAnswer(longXs, answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }


    }

    private static void setLongXsFromXs(String[] Xs, long[] intXs) {
        for (int i = 0; i < Xs.length; i++) {
            intXs[i] = Long.parseLong(Xs[i]);
        }
    }

    private static void setAnswer(long[] longXs, int[] answer) {

        for (int k = 0; k < longXs.length; k++) {

            long min = 9876543210L;
            min = getMin(longXs, min);

            if (min == 9876543210L) {
                return;
            }

            for (int i = 0; i < longXs.length; i++) {
                if (longXs[i] == min) {
                    answer[i] = k;
                    longXs[i] = 9876543210L;
                }
            }
        }
    }

    private static long getMin(long[] longXs, long min) {
        for (int i = 0; i < longXs.length; i++) {
            min = Math.min(longXs[i], min);
        }
        return min;
    }
}
