package week6.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Kim_1520 {
    //내리막 길 : https://www.acmicpc.net/problem/1520 - 시간초과, dp 사고 흐름이 어떻게 되는지.. 39260kb	324ms
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m, h;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[m - 1][n - 1] = 1;
        dfsdp(0, 0);
        //dfs(0, 0);
        System.out.println(dp[0][0]);
    }

    static void dfsdp(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return;
        }
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (map[nx][ny] < map[x][y]) {
                if (dp[nx][ny] != 0) {
                    dp[x][y] += dp[nx][ny];
                    continue;
                }else{
                    dfsdp(nx,ny);
                    dp[x][y] += dp[nx][ny];
                }
            }
        }
    }

    static void dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            h++;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (map[nx][ny] < map[x][y] && !visited[nx][ny]) {
                dfs(nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
