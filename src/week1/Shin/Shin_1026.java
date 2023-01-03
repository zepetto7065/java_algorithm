package week1.Shin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 보물: https://www.acmicpc.net/problem/1026 - 224ms
public class Shin_1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += (A[i] * B[i]);
        }
        System.out.println(result);
    }
}
