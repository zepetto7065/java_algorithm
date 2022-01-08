package week6.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//12212kb 96ms
public class Yoo1149
{
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        //최소값만 찾아서 하면 안되나? -> 모든 경우의 수를 찾아서..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i< N ; i++){
            st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken()); //red
            cost[i][1] = Integer.parseInt(st.nextToken()); //green
            cost[i][2] = Integer.parseInt(st.nextToken()); //blue
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(getCost(N-1, 0), Math.min(getCost(N-1, 1), getCost(N-1, 2))));
    }

    private static int getCost(int N, int color) {
        if(dp[N][color] == 0){ // 탐색 전
            switch (color){
                case 0:
                    dp[N][0] = Math.min(getCost(N -1 , 1),getCost(N-1, 2)) + cost[N][0];
                    break;
                case 1:
                    dp[N][1] = Math.min(getCost(N -1 , 0),getCost(N-1, 2)) + cost[N][1];
                    break;
                case 2:
                    dp[N][2] = Math.min(getCost(N -1 , 0),getCost(N-1, 1)) + cost[N][2];
                    break;
            }
        }
        return dp[N][color];
    }

}
