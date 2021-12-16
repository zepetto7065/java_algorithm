package week3.Shin;

import java.io.*;

// 수 정렬하기 3: https://www.acmicpc.net/problem/10989 - 1972ms
public class Shin_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] result = new int[N];
        int[] counting = new int[10001];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < numbers.length; i++) {
            counting[numbers[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int value = numbers[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        for (int value : result) {
            bw.append(value + "\n");
        }

        bw.close();
    }
}
