package week4.Kim;
/*테스트 1 〉	통과 (0.04ms, 81.7MB)
테스트 2 〉	통과 (0.06ms, 78.3MB)
테스트 3 〉	통과 (0.07ms, 77.6MB)
테스트 4 〉	통과 (0.05ms, 78.7MB)
테스트 5 〉	통과 (0.07ms, 74.7MB)
테스트 6 〉	통과 (0.06ms, 75.9MB)
테스트 7 〉	통과 (0.05ms, 74MB)
테스트 8 〉	통과 (0.07ms, 72.1MB)
테스트 9 〉	통과 (0.03ms, 70.4MB)
테스트 10 〉	통과 (0.03ms, 75.6MB)
테스트 11 〉	통과 (0.05ms, 79.6MB)
테스트 12 〉	통과 (0.10ms, 77.3MB)
테스트 13 〉	통과 (0.05ms, 76.7MB)
테스트 14 〉	통과 (0.04ms, 76.4MB)
테스트 15 〉	통과 (0.05ms, 74.6MB)
테스트 16 〉	통과 (0.11ms, 84.3MB)
테스트 17 〉	통과 (0.12ms, 77MB)
테스트 18 〉	통과 (0.13ms, 74.8MB)
테스트 19 〉	통과 (0.23ms, 73.9MB)
테스트 20 〉	통과 (0.17ms, 73.6MB)
테스트 21 〉	통과 (0.17ms, 76.7MB)
테스트 22 〉	통과 (0.18ms, 75.5MB)
테스트 23 〉	통과 (0.14ms, 85.8MB)
테스트 24 〉	통과 (0.20ms, 78.3MB)
테스트 25 〉	통과 (0.13ms, 74.5MB)
테스트 26 〉	통과 (0.15ms, 75MB)*/
public class Kim {
    //2021 KAKAO BLIND RECRUITMENT > 신규 아이디 추천 : https://programmers.co.kr/learn/courses/30/lessons/72410
    public static void main(String[] args) {
        Kim kim = new Kim();
        System.out.println(kim.solution(					"...!@BaT#*..y.abcdefghijklm"));
    }

    public String solution(String new_id) {
        StringBuilder answer;
        new_id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char target;
        char last = new_id.charAt(0);

        for (int i = 0; i < new_id.length(); i++) {
            target = new_id.charAt(i);
            if (i>0 && target == '.' && last == '.') continue;
            if (
                (target >= 'a' && target <= 'z') ||
                (target >= '0' && target <= '9') ||
                target == '-' || target == '_' || target == '.'
            ){
                sb.append(target);
                last = target;
            }
        }

        answer = new StringBuilder(sb.toString());
        if ((answer.length() > 0) && answer.charAt(0)=='.') answer = new StringBuilder(answer.substring(1));
        if ((answer.length() > 0) && answer.charAt(answer.length()-1)=='.') answer = new StringBuilder(answer.substring(0, answer.length() - 1));

        if (answer.length() >=15) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (answer.charAt(14) == '.') answer = new StringBuilder(answer.substring(0, 14));
        }

        if (answer.length()==0) answer = new StringBuilder("aaa");

        if (answer.length() < 3) {
            last = answer.charAt(answer.length()-1);
            while (answer.length() < 3) {
                answer.append(last);
            }
        }
        return answer.toString();
    }
}
