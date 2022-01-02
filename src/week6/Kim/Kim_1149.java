package week6.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kim_1149 {
    static int[][] cost;
    static int[][] dp;
    //RGB거리 : https://www.acmicpc.net/problem/1149 - 12196kb	120ms X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cost = new int[N][3];
        dp = new int[N][3];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); //R
            cost[i][1] = Integer.parseInt(st.nextToken()); //G
            cost[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(calc(N-1,0),Math.min(calc(N-1,1),calc(N-1,2))));
    }

    static int calc(int N, int color) {
        if (dp[N][color]==0) {
            if (color == 0) {
                dp[N][0] = Math.min(calc(N-1,1),calc(N-1,2))+cost[N][0];
            }
            else if (color == 1) {
                dp[N][1] = Math.min(calc(N-1,0),calc(N-1,2))+cost[N][1];
            }
            else {
                dp[N][2] = Math.min(calc(N-1,0),calc(N-1,1))+cost[N][2];
            }
        }
        return dp[N][color];
    }
}
