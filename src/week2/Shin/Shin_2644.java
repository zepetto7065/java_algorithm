package week2.Shin;

import java.util.Scanner;

// 촌수계산: https://www.acmicpc.net/problem/2644 - 212ms
public class Shin_2644 {

    private static int N;
    private static int M;
    private static boolean[][] map;
    private static boolean[] visited;
    private static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            map[v1][v2] = true;
            map[v2][v1] = true;
        }
        find(x, y, 0);
        System.out.println(result);
    }

    private static void find(int now, int target, int count) {
        if (now == target) {
            result = count;
            return;
        }

        visited[now] = true;
        for (int next = 1; next <= N; next++) {
            if (!visited[next] && map[now][next] == true) {
                find(next, target, count + 1);
            }
        }
    }
}
