package week2.Yun;


import java.util.*;

public class Yun_2606 {

    static int n, m;
    static boolean[] visited = new boolean[101];
    static List<ArrayList<Integer>> lists = new ArrayList<>(101);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        System.out.println(bfs(1) - 1);  // 1번 컴퓨터 제외한 대수


    }

    static int bfs(int Number) {
        int numberOfDefectedComputer = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[Number] = true;
        queue.offer(Number);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            numberOfDefectedComputer++;

            for (int i = 0; i < lists.get(x).size(); i++) {
                int numberToCheck = lists.get(x).get(i);
                if (visited[numberToCheck] == true) {
                    continue;
                }
                visited[numberToCheck] = true;
                queue.offer(numberToCheck);
            }
        }

        return numberOfDefectedComputer;
    }
}
