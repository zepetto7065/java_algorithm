package week4.Shin;

/*
    테스트 1 〉	통과 (0.22ms, 80.3MB)
    테스트 2 〉	통과 (11.90ms, 73.3MB)
    테스트 3 〉	통과 (11.73ms, 78.4MB)
    테스트 4 〉	통과 (0.20ms, 76.1MB)
    테스트 5 〉	통과 (0.37ms, 77.8MB)
    테스트 6 〉	통과 (0.21ms, 77.7MB)
    테스트 7 〉	통과 (0.24ms, 64.1MB)
    테스트 8 〉	통과 (0.33ms, 81.9MB)
    테스트 9 〉	통과 (11.04ms, 74.8MB)
    테스트 10 〉	통과 (0.19ms, 74MB)
    테스트 11 〉	통과 (0.28ms, 74.8MB)
    테스트 12 〉	통과 (0.52ms, 72.2MB)
    테스트 13 〉	통과 (16.41ms, 75MB)
    테스트 14 〉	통과 (0.24ms, 77.7MB)
    테스트 15 〉	통과 (0.28ms, 81.4MB)
    테스트 16 〉	통과 (0.66ms, 80.3MB)
    테스트 17 〉	통과 (1.42ms, 70.5MB)
    테스트 18 〉	통과 (2.19ms, 70.8MB)
    테스트 19 〉	통과 (2.52ms, 67.8MB)
    테스트 20 〉	통과 (3.40ms, 72.5MB)
    테스트 21 〉	통과 (4.98ms, 72.6MB)
    테스트 22 〉	통과 (12.69ms, 77MB)
    테스트 23 〉	통과 (15.50ms, 73.6MB)
    테스트 24 〉	통과 (1.35ms, 73.6MB)
    테스트 25 〉	통과 (1.69ms, 85.9MB)
    테스트 26 〉	통과 (1.50ms, 75.7MB)
*/
// 신규 아이디 추천: https://programmers.co.kr/learn/courses/30/lessons/72410
public class Shin_신규아이디추천 {

    public static String solution(String new_id) {
        String answer = new_id;
        answer = answer.toLowerCase();
        answer = answer.replaceAll("[^-_.0-9a-z]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        if (answer.startsWith(".")) {
            StringBuilder sb = new StringBuilder(answer);
            sb.deleteCharAt(0);
            answer = sb.toString();
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.isBlank()) {
            answer = "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, 14);
        }
        if (answer.length() <= 2) {
            char lastWord = answer.charAt(answer.length() - 1);
            while (answer.length() != 3) {
                answer += lastWord;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
