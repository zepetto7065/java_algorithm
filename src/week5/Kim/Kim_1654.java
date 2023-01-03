package week5.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kim_1654 {
    //나무자르기 : https://www.acmicpc.net/problem/1654 - 15540kb	144ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max = arr[K - 1];
        long min = 1;
        long middle = 0;
        while (max >= min) {
            middle = (max + min) / 2;
            long cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                cnt += (arr[j] / middle);
            }

            if (cnt >= N) {
                min = middle + 1;
            } else if (cnt < N) {
                max = middle - 1;
            }
        }
        System.out.println(max);
    }
}