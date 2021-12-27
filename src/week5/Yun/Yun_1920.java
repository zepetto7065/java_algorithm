package week5.Yun;

import java.util.Arrays;
import java.util.Scanner;

// 186876	2032

public class Yun_1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        setArray(scanner, n, array);

        Arrays.sort(array);

        int m = scanner.nextInt();
        int[] elements = new int[m];
        setElements(scanner, m, elements);

        print(array, elements);


    }

    private static void print(int[] array, int[] elements) {
        for (int element : elements) {
            if (checkArrayHasElement(array, element)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static void setElements(Scanner scanner, int m, int[] elements) {
        for (int i = 0; i < m; i++) {
            elements[i] = scanner.nextInt();
        }
    }

    private static void setArray(Scanner scanner, int n, int[] array) {
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
    }

    static boolean checkArrayHasElement(int[] array, int element) {
        int indexOfLeft = 0;
        int indexOfright = array.length - 1;
        int i = 0;

        if (element == array[indexOfLeft]) {
            return true;
        }

        if (element == array[indexOfright]) {
            return true;
        }

        while (true) {
            i++;
            if (i > 35) {
                return false;
            }

            int indexOfMiddle = (indexOfLeft + indexOfright) / 2;

            if (element == array[indexOfMiddle]) {
                return true;
            }
            if (element > array[indexOfMiddle]) {
                indexOfLeft = indexOfMiddle;
                continue;
            }
            if (element < array[indexOfMiddle]) {
                indexOfright = indexOfMiddle;
                continue;
            }
        }
    }
}
