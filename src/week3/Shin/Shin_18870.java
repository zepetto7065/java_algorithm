package week3.Shin;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// 좌표 압축: https://www.acmicpc.net/problem/18870 - 2144ms
public class Shin_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        AtomicInteger index = new AtomicInteger();
        Map<Integer, Integer> sortedMap = Arrays.stream(numbers)
                .boxed()
                .sorted()
                .distinct()
                .collect(Collectors.toMap(i -> i, i -> index.getAndIncrement()));

        for (int number : numbers) {
            bw.append(sortedMap.get(number) + " ");
        }
        
        bw.close();
    }
}
