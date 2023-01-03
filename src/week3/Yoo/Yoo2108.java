package week3.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class Yoo2108 {
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        //sorting
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        sansool(numbers);
        joongang(numbers);
        chaibin(numbers);
        bummi(numbers);
    }

    private static void bummi(int[] numbers) {
        int leng = numbers.length;
        if (leng == 1) {
            System.out.println(1);
        } else {
            System.out.println(numbers[numbers.length - 1] - numbers[0]);
        }
    }

    private static void chaibin(int[] numbers) {
        int[] count = new int[500001];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }
        
    }

    private static void joongang(int[] numbers) {
        int mid = numbers.length / 2;
        System.out.println(numbers[mid]);
    }

    private static void sansool(int[] numbers) {
        float sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        int result = Math.round(sum / numbers.length);
        System.out.println(result);
    }
}
