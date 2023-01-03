package week10.Shin;

import java.util.ArrayList;
import java.util.List;

// 소수 찾기: https://programmers.co.kr/learn/courses/30/lessons/42839
public class Shin_소수찾기 {

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        List<Integer> numberList = new ArrayList<>();
        boolean[] check = new boolean[numbers.length()];
        String temp = "";

        for (int i = 1; i <= numbers.length(); i++) {
            makeNumber(numberList, check, numbers, temp, i);
        }
        
        return (int) numberList.stream()
                .filter(n -> isPrimeNumber(n))
                .count();
    }

    private static void makeNumber(List<Integer> numberList, boolean[] check, String numbers, String temp, int length) {
        if (temp.length() == length) {
            int number = Integer.parseInt(temp);
            if (!numberList.contains(number)) {
                numberList.add(number);
            }

            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (check[i]) {
                continue;
            }

            temp += numbers.charAt(i);

            check[i] = true;
            makeNumber(numberList, check, numbers, temp, length);
            check[i] = false;

            temp = temp.substring(0, temp.length() - 1);
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
