package week8.Shin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 전화번호 목록: https://programmers.co.kr/learn/courses/30/lessons/42577
public class Shin_전화번호목록 {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "1191123123123123", "97674223", "1195524421"};
        System.out.println(solutionByHashSet(phoneBook));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean solutionByHashSet(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String p : phone_book) {
            set.add(p);
        }

        for (String s : set) {
            for (int i = 1; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
