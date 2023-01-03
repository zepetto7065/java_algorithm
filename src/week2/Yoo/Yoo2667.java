package week2.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Yoo2667 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static List<Integer> aparts = new ArrayList<>(); //단지수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[n][n];
        visited[0][0] = true;

        //맵전체를 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(aparts.size());
        Collections.sort(aparts);
        for (int num : aparts) {
            System.out.println(num);
        }
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { a, b });

        int count = 0; //
        while (!q.isEmpty()) {
            int[] out = q.poll();
            int nowX = out[0];
            int nowY = out[1];

            //동서남북 체크
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                q.add(new int[] { nextX, nextY });
                visited[nextX][nextY] = true;
                count++;
            }
        }
        aparts.add(count);

    }
}
