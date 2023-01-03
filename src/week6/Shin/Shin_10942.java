package week6.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팰린드롬?: https://www.acmicpc.net/problem/10942 - 시간초과
public class Shin_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[][] indexes = new int[M][2];
        for (int i = 0; i < M; i++) {
            StringTokenizer indexSt = new StringTokenizer(br.readLine());
            indexes[i][0] = Integer.parseInt(indexSt.nextToken());
            indexes[i][1] = Integer.parseInt(indexSt.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(isPalindrome(numbers, indexes[i]));
        }
    }

    private static int isPalindrome(int[] numbers, int[] index) {
        int left = index[0] - 1;
        int right = index[1] - 1;

        while (left < right) {
            if (numbers[left] != numbers[right]) {
                return 0;
            }
            left++;
            right--;
        }
        return 1;
    }
}
