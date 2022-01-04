package week1.Shin;

import java.util.Scanner;

// 설탕배달: https://www.acmicpc.net/problem/2839 - 208ms
public class Shin_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;
        while (true) {
            if (N < 0) {
                result = -1;
                break;
            }

            if (N == 0) {
                break;
            }

            if (N % 5 == 0) {
                result += (N / 5);
                break;
            }

            N -= 3;
            result++;
        }

        System.out.println(result);
    }
}
