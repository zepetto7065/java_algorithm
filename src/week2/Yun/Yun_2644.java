package week2.Yun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yun_2644 {

    static int n, m;
    static int startNumber, endNumber;
    static int chonsoo;
    static boolean[] visited = new boolean[101];
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        startNumber = sc.nextInt();
        endNumber = sc.nextInt();
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

        System.out.println(bfs(startNumber));


    }

    static int bfs(int startNumber) {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.add(startNumber);
        visited[startNumber] = true;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                int numberToCheck = queue1.poll();
                if (numberToCheck == endNumber) {
                    return chonsoo;
                }

                for (int i = 0; i < lists.get(numberToCheck).size(); i++) {
                    int x = lists.get(numberToCheck).get(i);

                    if (visited[x] == true) {
                        continue;
                    }
                    queue2.offer(x);
                    visited[x] = true;
                }
            }
            chonsoo++;

            while (!queue2.isEmpty()) {
                int numberToCheck = queue2.poll();
                if (numberToCheck == endNumber) {
                    return chonsoo;
                }
                for (int i = 0; i < lists.get(numberToCheck).size(); i++) {
                    int x = lists.get(numberToCheck).get(i);

                    if (visited[x] == true) {
                        continue;
                    }
                    queue1.offer(x);
                    visited[x] = true;
                }

            }
            chonsoo++;
        }

        return -1;
    }
}
