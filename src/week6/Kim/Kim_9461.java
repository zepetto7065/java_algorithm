package week6.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kim_9461 {
    static long[] dp;
    //파도반 수열 : https://www.acmicpc.net/problem/9461 - 11404kb	80ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i=6;i<101;i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
