package week8.Shin;

import java.util.HashMap;
import java.util.Map;

// 위장: https://programmers.co.kr/learn/courses/30/lessons/42578
public class Shin_위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        int result = 1;
        for (String key : map.keySet()) {
            result *= map.get(key) + 1;
        }

        return result - 1;
    }
}
