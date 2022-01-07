package week6.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kim_1003 {
    static Integer[][] dp = new Integer[41][2];

    //피보나치 함수 : https://www.acmicpc.net/problem/1003 - 11460kb	80ms X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            Fibonacci(N);
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    private static Integer[] Fibonacci(int N) {
        if (dp[N][0]==null || dp[N][1]==null) {
            dp[N][0] = Fibonacci(N-1)[0] + Fibonacci(N-2)[0];
            dp[N][1] = Fibonacci(N-1)[1] + Fibonacci(N-2)[1];
        }
        return dp[N];
    }
}
