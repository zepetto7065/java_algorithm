package week2.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoo2606 {
    static boolean[] check;
    static int[][] map;
    static int n;
    static int m;
    static int count;

    //11692KB 80ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        check = new boolean[n + 1];
        //        dfs(1);
        bfs(1);
        System.out.println(count);
    }

    private static void bfs(int computer) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(computer);
        check[computer] = true;

        while (!q.isEmpty()) {
            int out = q.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[i][out] == 1 && check[i] == false && i != out) {
                    q.offer(i);
                    count++;
                    check[i] = true;
                }
            }

        }
    }

    private static void dfs(int computer) {
        check[computer] = true; //방문체크

        for (int i = 0; i < n; i++) {
            if (map[i][computer] == 1 && !check[i]) {
                count++;
                dfs(i);
            }
        }
    }
}
