package week10.Yoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yoo_모의고사 {
    public static void main(String[] args) {
        int[] answers = new int[]{1,2,3,4,5};
        int[] solution = solution(answers);
        Arrays.stream(solution).forEach(System.out::println);
    }

    private static int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();

        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};

        int[] scores = {0,0,0}; //맞춘 횟수

        for(int i = 0; i< answers.length; i++){
            if(first[i % 5] == answers[i]) scores[0]++;
            if(second[i % 8] == answers[i]) scores[1]++;
            if(third[i % 10] == answers[i]) scores[2]++;
        }

        int[] arr = Arrays.stream(scores)
                            .sorted()
                            .toArray();

        for(int i =0 ; i< arr.length; i++){
            if(scores[i] == arr[2]){ //가장 많이 맞춘 갯수와 비교
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
