package week6.Yoo;

public class bemin {
    public static void main(String[] args) {
        int[] c = new int[]{2,2,1,1,0,1};
        System.out.println(solution(3,3, c));

    }

    private static String solution(int U, int L, int[] C) {
        int[][] matrix = new int[C.length][2];

        for(int i =0; i < C.length; i++){
            if(C[i] == 0){
                matrix[i][0] = 0;
                matrix[i][1] = 0;
            }else if(C[i] == 2){
                matrix[i][0] = 1;
                matrix[i][1] = 1;
                U -= 1;
                L -= 1;
            }
        }

        for(int i = 0; i < C.length; i++){
            if( C[i] == 1 ){
                if(U > 0){
                    matrix[i][0] = 1;
                    U -= 1;
                }else if(L > 0){
                    matrix[i][1] = 1;
                    L -= 1;
                }
            }
        }

        if(U > 0 || L > 0) return "IMPOSSIBLE";

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i< C.length; i++){
            sb.append(matrix[i][0]);
            sb2.append(matrix[i][1]);
        }
        return sb.append(",").append(sb2).toString();
    }
}
