package week2.Shin;

import java.util.*;

// DFS와 BFS: https://www.acmicpc.net/problem/1260 - 648ms
public class Shin_1260 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        List<Integer>[] links = new ArrayList[N + 1];
        boolean[] check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            links[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            links[v1].add(v2);
            links[v2].add(v1);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(links[i]);
        }

        dfs(links, check, V);
        System.out.println();
        Arrays.fill(check, false);
        bfs(links, check, V);
    }

    private static void dfs(List<Integer>[] links, boolean[] check, int v) {
        if (check[v]) {
            return;
        }

        check[v] = true;
        System.out.print(v + " ");

        for (int nextV : links[v]) {
            dfs(links, check, nextV);
        }
    }

    private static void bfs(List<Integer>[] links, boolean[] check, int v) {
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.offer(v);

        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");

            for (int nextV : links[v]) {
                if (!check[nextV]) {
                    q.offer(nextV);
                    check[nextV] = true;
                }
            }
        }
    }
}
