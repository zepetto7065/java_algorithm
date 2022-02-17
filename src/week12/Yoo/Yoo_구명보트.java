package week12.Yoo;

import java.util.Arrays;

public class Yoo_구명보트 {
    public static void main(String[] args) {
        int[] people = {70,50,80,50};
        int limit  = 100;

        solution(people,limit);
    }

    private static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        int idx = 0;

        //제일 작은 것과 큰것
        for(int max = people.length -1 ; idx <= max; max--){
            if(people[idx] + people[max] <= limit) idx++;
            answer++;
        }
        
        return answer;
    }
}
