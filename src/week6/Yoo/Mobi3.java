package week6.Yoo;

import java.util.Arrays;

public class Mobi3 {
    public static void main(String[] args) {
        int[] A = new int[]{7,4,-2,4,-2,-9};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        if (A.length == 1) return 1;

        int even = A[0];
        int odd = A[1];
        int start = 0;
        int max = 0;

        for (int i = 2; i < A.length; i++) {
            if (i % 2 == 0 && A[i] != even || i % 2 == 1 && A[i] != odd) {
                max = Math.max(max, i - start);
                start = i - 1;

                if (i % 2 == 0) {
                    even = A[i];
                    odd = A[i - 1];
                } else {
                    even = A[i - 1];
                    odd = A[i];
                }
            }
        }
        return Math.max(max, A.length - start);
    }
}
