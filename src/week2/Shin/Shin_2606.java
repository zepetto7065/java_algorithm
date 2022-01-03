package week2.Shin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 바이러스: https://www.acmicpc.net/problem/2606 - 240ms
public class Shin_2606 {

    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer>[] links = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            links[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            links[v1].add(v2);
            links[v2].add(v1);
        }

        dfs(1, links, visited);
        System.out.println(count - 1);
    }

    private static void dfs(int v, List<Integer>[] links, boolean[] visited) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        count++;

        for (int nextV : links[v]) {
            dfs(nextV, links, visited);
        }
    }
}
