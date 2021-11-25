package week0;

import java.util.Scanner;

public class Yoo {
    //greedy 예시 문제
    public void problem1() {
        //        10 4790
        //        1
        //        5
        //        10
        //        50
        //        100
        //        500
        //        1000
        //        5000
        //        10000
        //        50000

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("n = " + n);
        int k = sc.nextInt();
        System.out.println("k = " + k);
        int[] coins = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            System.out.println("coins[i] = " + coins[i]);
        }

        for (int i = coins.length - 1; i > 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }

        System.out.println(result);
    }
}
