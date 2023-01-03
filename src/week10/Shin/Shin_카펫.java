package week10.Shin;

import java.util.Arrays;

// 카펫: https://programmers.co.kr/learn/courses/30/lessons/42842
public class Shin_카펫 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(10, 2)));
//        System.out.println(Arrays.toString(solution(14, 4)));
//        System.out.println(Arrays.toString(solution(12, 4)));
//        System.out.println(Arrays.toString(solution(8, 1)));
//        System.out.println(Arrays.toString(solution(16, 5)));
        System.out.println(Arrays.toString(solution(16, 9)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) {
                continue;
            }
            int width = yellow / i;
            int height = i;
            int perimeter = 4 + ((width + height) * 2);
            if (perimeter == brown) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        return answer;
    }
}
