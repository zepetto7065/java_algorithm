package week1.Shin;

import java.util.Scanner;

//동전 0: https://www.acmicpc.net/problem/11047 - 208ms
public class Shin_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            count += (M / coins[i]);
            M %= coins[i];
        }
        System.out.println(count);
    }
}
