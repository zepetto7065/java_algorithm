package week6.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파도반 수열: https://www.acmicpc.net/problem/9461 - 128ms
public class Shin_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        int[] numbers = new int[T];
        for (int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[numbers[i]]);
        }
    }
}
