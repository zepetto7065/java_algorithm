package week11.Park;

import java.util.Arrays;

public class Park_HIndex {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            // 인용횟수 와 발표한 논문수 비교
            // 최대값을 구해야 하니 하나씩 줄여가면서 비교하기
            int h = Math.min(citations[i], citations.length - i);

            // h값 중 최대값
            answer = Math.max(answer, h);
        }
        return answer;
    }
}

