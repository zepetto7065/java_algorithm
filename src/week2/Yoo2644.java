package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yoo2644 {
    static int n;
    static int m;
    static int[] check;
    static int[][] map;
    static int count;
    static int start;
    static int end;

    //11656KB 76ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[c][d] = 1;
            map[d][c] = 1;
        }

        check = new int[n + 1];
        bfs(start);
        if (check[end] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(check[end]);
        }
    }

    private static void bfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);

        while (!q.isEmpty()) {
            int out = q.poll();
            if (out == end) {
                break;
            }
            for (int i = 1; i <= n; i++) {
                if (map[i][out] == 1 && check[i] == 0 && i != out) {
                    q.offer(i);
                    check[i] = check[out] + 1;
                }
            }

        }
    }
}
