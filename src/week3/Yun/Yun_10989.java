package week3.Yun;

import java.util.Scanner;

public class Yun_10989 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();

        int[] countingNumberOfElements = new int[10001];

        for (int i = 0; i < numberOfElements; i++) {
            countingNumberOfElements[scanner.nextInt()]++;
        }

        for (int i = 0; i < countingNumberOfElements.length; i++) {
            for (int j = 0; j < countingNumberOfElements[i]; j++) {
                System.out.println(i);
            }
        }
    }
}
