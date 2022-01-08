package week6.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수: https://www.acmicpc.net/problem/1003 - 152ms
public class Shin_1003 {

    private static Fibo[] fibo = new Fibo[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] numbers = new int[T];
        for (int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        fibo[0] = new Fibo(1, 0);
        fibo[1] = new Fibo(0, 1);
        for (int i = 2; i < 41; i++) {
            int nextZeroCount = fibo[i - 1].zeroCount + fibo[i - 2].zeroCount;
            int nextOneCount = fibo[i - 1].oneCount + fibo[i - 2].oneCount;

            fibo[i] = new Fibo(nextZeroCount, nextOneCount);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(fibo[numbers[i]]);
        }
    }

    static class Fibo {
        int zeroCount;
        int oneCount;

        public Fibo(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        @Override
        public String toString() {
            return zeroCount + " " + oneCount;
        }
    }
}
