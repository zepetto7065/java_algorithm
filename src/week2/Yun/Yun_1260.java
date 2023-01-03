package week2.Yun;

import java.util.*;

public class Yun_1260 {

    public static int n, m, v;
    public static boolean[] visited = new boolean[1001];
    public static boolean[] visited2 = new boolean[1001];
    public static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        for (int i = 0; i < lists.size(); i++) {
            Collections.sort(lists.get(i));
        }

        dfs(v);
        bfs(v);
    }

    public static void dfs(int x) {
        visited[x] = true;
        System.out.println(x);

        for (int i = 0; i < lists.get(x).size(); i++) {
            int y = lists.get(x).get(i);
            if (!visited[y]) dfs(y);
        }

    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visited2[x] = true;
        queue.offer(x);

        while (!queue.isEmpty()) {
            int y = queue.poll();
            System.out.println(y);

            for (int i = 0; i < lists.get(y).size(); i++) {
                int z = lists.get(y).get(i);
                if (!visited2[z]) {
                    visited2[z] = true;
                    queue.offer(z);
                }
            }
        }
    }

}