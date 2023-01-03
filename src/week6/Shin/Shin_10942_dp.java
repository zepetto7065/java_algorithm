package week6.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팰린드롬?: https://www.acmicpc.net/problem/10942 - 744ms
public class Shin_10942_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1] = true;
                dp[i + 1][i] = true;
            }
            dp[i][i] = true;
        }
        dp[N - 1][N - 1] = true;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (numbers[j] == numbers[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer indexSt = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(indexSt.nextToken()) - 1;
            int right = Integer.parseInt(indexSt.nextToken()) - 1;
            if (dp[left][right]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }
}
