package week5.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 자르기: https://www.acmicpc.net/problem/2805 - 512ms
public class Shin_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, numbers[i]);
        }

        long left = 0;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int number : numbers) {
                if (number > mid) {
                    sum += number - mid;
                }
            }

            if (sum >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
