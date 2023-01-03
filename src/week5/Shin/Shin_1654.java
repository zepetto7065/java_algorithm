package week5.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 랜 자르기: https://www.acmicpc.net/problem/1654 - 196ms
public class Shin_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, numbers[i]);
        }

        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += (numbers[i] / mid);
            }

            if (sum >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
