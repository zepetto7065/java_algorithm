package week3.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yoo10989 {
    //O(n^2) 계수정렬
    //4840496KB 1700ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //        int[] numbers = new int[n];
        int[] cnt = new int[10001];

        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        //509972KB 2400ms
        //        Arrays.sort(numbers); //dual-pivot Quick sort

        StringBuilder sb = new StringBuilder();
        //        for (int num : numbers) {
        //            sb.append(num).append('\n');
        //        }
        for (int i = 1; i < 10001; i++) {
            while (cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
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
