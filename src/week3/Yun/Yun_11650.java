package week3.Yun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Yun_11650 {  //192084	2308
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfNode = scanner.nextInt();

        Node[] arrayOfNode = new Node[numberOfNode];

        for (int i = 0; i < numberOfNode; i++) {
            arrayOfNode[i] = new Node(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(arrayOfNode, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
        });

        for (int i = 0; i < arrayOfNode.length; i++) {
            System.out.println(arrayOfNode[i].x + " " + arrayOfNode[i].y);
        }


    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
