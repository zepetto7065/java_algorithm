package week2.Yun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yun_2178 {

    public static int n, m;
    public static int[][] array2D = new int[101][101];

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                array2D[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeX = node.getX();
            int nodeY = node.getY();

            for (int i = 0; i < 4; i++) {
                int newX = nodeX + dx[i];
                int newY = nodeY + dy[i];

                if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
                    continue;
                }

                if (array2D[newX][newY] == 1) {
                    array2D[newX][newY] = array2D[nodeX][nodeY] + 1;
                    queue.offer(new Node(newX, newY));
                }
            }
        }

        return array2D[n - 1][m - 1];
    }

}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }
}