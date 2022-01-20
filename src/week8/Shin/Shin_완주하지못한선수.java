package week8.Shin;

import java.util.HashMap;
import java.util.Map;

// 완주하지 못한 선수: https://programmers.co.kr/learn/courses/30/lessons/42576
public class Shin_완주하지못한선수 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }
        
        return map.keySet().stream()
                .filter(key -> map.get(key) != 0)
                .findFirst()
                .get();
    }
}
