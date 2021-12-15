package week3.Yun;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Yun_11651 { // 185932	2444
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
                if (o1.y != o2.y) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < arrayOfNode.length; i++) {
            System.out.println(arrayOfNode[i].x + " " + arrayOfNode[i].y);
        }


    }
}