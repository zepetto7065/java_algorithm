package week3.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoo10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
        }

        sort(numbers);

        for (int num : numbers) {
            System.out.println(num);
        }
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = tmp;
        }
    }

}
