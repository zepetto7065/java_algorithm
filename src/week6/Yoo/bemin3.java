package week6.Yoo;

import java.util.Arrays;

public class bemin3 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,-4};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        Arrays.sort(A);

        for(int i = 0; i < A.length-1; i++){
            if(A[i] > 0) break;
            for(int j = A.length-1; j > 0; j--){
                if(A[j] < 0) break;
                if(A[j] == -A[i]){
                    return A[j];
                }
            }
        }
        return 0;
    }
}
