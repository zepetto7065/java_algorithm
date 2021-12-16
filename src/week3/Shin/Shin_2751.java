package week3.Shin;

import java.io.*;

// 수 정렬하기 2: https://www.acmicpc.net/problem/2751 - 1000ms
public class Shin_2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int[] tmp = new int[N];

        mergeSort(numbers, tmp, 0, numbers.length - 1);

        for (int number : numbers) {
            bw.append(number + "\n");
        }

        bw.close();
    }

    private static void mergeSort(int[] numbers, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(numbers, tmp, start, mid);
            mergeSort(numbers, tmp, mid + 1, end);
            merge(numbers, tmp, start, mid, end);
        }
    }

    private static void merge(int[] numbers, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = numbers[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                numbers[index] = tmp[part1];
                part1++;
            } else {
                numbers[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            numbers[index + i] = tmp[part1 + i];
        }
    }
}
