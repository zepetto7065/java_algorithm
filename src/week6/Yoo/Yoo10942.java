package week6.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//팰린드롬 - 앞뒤가 똑같은
//229804KB 668ms
public class Yoo10942 {
    static int[] numbers;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N+1];
        dp = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        felindrom(N);
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end]){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void felindrom(int N) {
//        while (S<E){
//            if(numbers[S++] != numbers[E++]){
//                return 0;
//            }
//        }
//        return 1;
        //길이가 1인 경우
        for(int i = 1; i<= N ; i++){
            dp[i][i] = true;
        }

        //길이가 2인데 수가 같을 경우
        for(int i = 1; i<= N-1; i++){
            if(numbers[i] == numbers[i+1]) dp[i][i+1] = true;
        }

        //길이가 3이상 일때, (시작점+1) ~ (끝-1)까지 펠린드롬 && 시작점 = 끝점
        for(int i = 2; i< N; i++){
            for(int j = 1; j<= N-i; j++){
                if(numbers[j] == numbers[j+i] && dp[j+1][j+i-1]) {
                    dp[j][j+i] = true;
                }
            }
        }
    }

}
