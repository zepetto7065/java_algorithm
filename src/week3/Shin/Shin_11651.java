package week3.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 좌표 정렬하기 2: https://www.acmicpc.net/problem/11651 - 1692ms
public class Shin_11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int[] numbers : arr) {
            String[] inputs = br.readLine().split(" ");
            numbers[0] = Integer.parseInt(inputs[0]);
            numbers[1] = Integer.parseInt(inputs[1]);
        }

        Arrays.sort(arr, (n1, n2) -> {
            if (n1[1] == n2[1]) {
                return Integer.compare(n1[0], n2[0]);
            }
            return Integer.compare(n1[1], n2[1]);
        });

        for (int[] numbers : arr) {
            System.out.println(numbers[0] + " " + numbers[1]);
        }
    }
}
