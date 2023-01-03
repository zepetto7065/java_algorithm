package week3.Yun;

import java.util.Arrays;
import java.util.Scanner;

public class Yun_2750 { //	22184	332
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElement = scanner.nextInt();

        int[] array = new int[numberOfElement];

        for (int i = 0; i < numberOfElement; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
