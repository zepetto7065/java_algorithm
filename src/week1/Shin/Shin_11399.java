package week1.Shin;

import java.util.Arrays;
import java.util.Scanner;

// ATM: https://www.acmicpc.net/problem/11399 - 280ms
public class Shin_11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = sc.nextInt();
        }
        Arrays.sort(people);
        int result = people[0];
        for (int i = 1; i < N; i++) {
            people[i] += people[i - 1];
            result += people[i];
        }
        System.out.println(result);
    }
}
