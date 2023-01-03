package week3.Shin;

import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

// 단어 정렬 - https://www.acmicpc.net/problem/1181 - 984ms
public class Shin_1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        IntStream.range(0, N)
                .mapToObj(i -> sc.next())
                .distinct()
                .sorted(comparing(String::length).thenComparing(s -> s))
                .forEach(System.out::println);
    }
}
