package week6.Yoo;

import java.util.Arrays;

public class bemin4 {
    public static void main(String[] args) {
        int[] A = new int[]{2,1,3,4,2,1};
        int[] B = new int[]{3,3,1};

        System.out.println(solution(A,B));
    }

    private static int solution(int[] A,int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n - 1; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
