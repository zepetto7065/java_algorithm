package week2.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoo2178 {
    static boolean[][] visited;
    static int[][] map;
    static int n;
    static int m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    //12264KB 96ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0'; //문자 1을 숫자로 , '0'은 아스키코드 48
            }
        }
        visited[0][0] = true; //방문

        //dfs? bfs?
        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);

    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { a, b });

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int targetX = nowX + dx[i];
                int targetY = nowY + dy[i];

                //미로를 벗어날 경우
                if (targetX < 0 || targetY < 0 || targetX >= n || targetY >= m)
                    continue;
                //방문했거나, 길이 없을 경우
                if (visited[targetX][targetY] || map[targetX][targetY] == 0)
                    continue;

                q.add(new int[] { targetX, targetY });
                map[targetX][targetY] = map[nowX][nowY] + 1;
                visited[targetX][targetY] = true;
            }
        }

    }

}
