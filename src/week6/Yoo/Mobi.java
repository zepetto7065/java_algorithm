package week6.Yoo;

import java.util.*;

public class Mobi {
    public static void main(String[] args) {
        String example = solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "example");
        System.out.println("example = " + example);
    }

    private static String solution(String S, String C) {
        String[] names = S.split(",");
        List<String> target = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String name : names) {
            StringBuilder sb = nameParser(name);
            //중복확인
            duplicationCheck(countMap, sb);
            //이메일 형태 만들기
            sb.append("@").append(C.toLowerCase()).append(".com");
            target.add(sb.toString());
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < names.length; i++){
            result.append(names[i]).append(" <").append(target.get(i)).append(">");
            if(i < names.length -1) result.append(",");
        }

        return result.toString();
    }

    private static StringBuilder nameParser(String name) {
        String[] strs = name.trim().toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            String sub = "";

            //미들네임 또는 퍼스트네임인가
            sub = strs[i].substring(0, 1);

            //마지막 글자
            if (i == strs.length - 1) {
                sub = strs[i];
                sub = sub.replace("-", "");
                if (sub.length() > 8) {
                    sub = sub.substring(0, 8);
                }
            }

            sb.append(sub);
        }
        return sb;
    }

    private static void duplicationCheck(Map<String, Integer> countMap, StringBuilder sb) {
        if (countMap.containsKey(sb.toString())) {
            countMap.put(sb.toString(), countMap.get(sb.toString()) + 1);
            sb.append(countMap.get(sb.toString()));
        } else {
            countMap.put(sb.toString(), 1);
        }
    }
}
