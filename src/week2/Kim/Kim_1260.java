package week2.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kim_1260 {
    public static int N;
    public static int M;

    public static List<Integer> dfsResult = new ArrayList<>();
    public static List<Integer> bfsResult = new ArrayList<>();
    public static boolean[] visited;
    public static boolean[][] map;

    //DFS와 BFS : https://www.acmicpc.net/problem/1260  - 288ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        int start, end;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = true;
            map[end][start] = true;
        }

        dfsResult.add(V);
        visited[V] = true;
        dfs(V);

        Arrays.fill(visited, false);
        bfsResult.add(V);
        visited[V] = true;
        bfs(V);
        for (Integer integer : dfsResult) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : bfsResult) {
            System.out.print(integer + " ");
        }
    }

    public static void dfs(int start) {
        for (int i = 1; i <= N; i++) {
            if (map[start][i] && !visited[i]) {
                visited[i] = true;
                dfsResult.add(i);
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[start][i] && !visited[i]) {
                    visited[i] = true;
                    bfsResult.add(i);
                    queue.add(i);
                }
            }
        }
    }
}
