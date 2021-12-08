package week2.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoo1260 {
    private boolean[] check;
    private int[][] map;
    int n;
    int m;
    int v;

    //1260(DFS와 BFS), 2178(미로 탐색), 2606(바이러스), 2667(단지번호붙이기) 2644(촌수계산)
    public static void main(String[] args) {
        System.out.println("main");
    }

    //메모리21420kb 시간304ms
    public void problem1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        check = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1; //행렬 제시
            map[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        check = new boolean[n + 1];
        bfs(v);
    }

    private void dfs(int target) {
        check[target] = true; //방문
        System.out.print(target + " ");
        for (int i = 1; i <= n; i++) {
            if (map[i][target] == 1 && check[i] == false) {
                dfs(i);
            }
        }
    }

    private void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);
        while (!q.isEmpty()) {
            int pullTarget = q.poll();
            check[pullTarget] = true;
            System.out.print(pullTarget + " ");
            for (int i = 1; i <= n; i++) {
                if (map[i][pullTarget] == 1 && check[i] == false && i != pullTarget) {
                    q.offer(i);
                    check[i] = true;
                }
            }
        }
    }

}
