package week2.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kim_2178 {
    public static int N;
    public static int M;

    public static int[][] miro;
    public static int[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    //미로탐색 : https://www.acmicpc.net/problem/2178 - 96ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        checkDist();
        System.out.println(visit[N-1][M-1]);
    }

    private static void checkDist() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] ready = queue.poll();
            int x = ready[0];
            int y = ready[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (miro[nx][ny]==1 && visit[nx][ny] == 0) {
                    visit[nx][ny] = visit[x][y] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}
