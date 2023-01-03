package week5.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기: https://www.acmicpc.net/problem/1920 - 1232ms
public class Shin_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = readLine(br, N);

        int M = Integer.parseInt(br.readLine());
        int[] targets = readLine(br, M);

        Arrays.sort(numbers);
        for (int i = 0; i < M; i++) {
            if (binarySearch(numbers, targets[i]) == -1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }

    private static int[] readLine(BufferedReader br, int count) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        return numbers;
    }

    private static int binarySearch(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (numbers[middle] > target) {
                right = middle - 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
