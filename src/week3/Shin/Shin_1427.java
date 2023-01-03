package week3.Shin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 소트인사이드: https://www.acmicpc.net/problem/1427 - 132ms
public class Shin_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Arrays.stream(line.split(""))
                .sorted(Collections.reverseOrder())
                .forEach(System.out::print);
    }
}
