package week11;

import java.util.*;

public class Yun_가장큰수 {

    // 안풀리는 풀이. 런타임 에러가 납니다. 왜 그럴까요??ㅠㅠㅠ
//    boolean[] visited;
//    int[] numbersArr;
//    List<Long> list = new ArrayList<>();
//
//    public String solution(int[] numbers) {
//        numbersArr = numbers;
//        visited = new boolean[numbersArr.length];
//
//        plus("");
//
//        Collections.sort(list);
//
//        return String.valueOf(list.get(list.size()-1));
//    }
//
//    public void plus(String str){
//        if(!str.equals("")) {
//            list.add(Long.parseLong(str));
//        }
//
//        for(int i=0; i<visited.length; i++){
//            if(visited[i]==false) {
//                visited[i] = true;
//                plus(str + numbersArr[i]);
//                visited[i] = false;
//            }
//        }
//    }
//    public String solution(int[] numbers) {  //얘도 같은 걸로 런타임 에러 생기네 테스트 10까지
//        String[] numbersStringArr = new String[numbers.length];
//        for (int i = 0; i < numbers.length; i++) {
//            numbersStringArr[i] = "" + numbers[i];
//        }
//
//        Arrays.sort(numbersStringArr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2 + o1).compareTo(o1 + o2);
//            }
//        });
//        String answer = "";
//        for (int i = 0; i < numbersStringArr.length; i++) {
//            answer += numbersStringArr[i];
//        }
//
//        if(Long.parseLong(answer)==0L){
//            return "0";
//        }
//
//        return answer;
//
//
//    }

    public String solution(int[] numbers) {
        String[] numbersStringArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersStringArr[i] = "" + numbers[i];
        }

        Arrays.sort(numbersStringArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        String answer = "";
        for (int i = 0; i < numbersStringArr.length; i++) {
            answer += numbersStringArr[i];
        }
        //        if(Long.parseLong(answer)==0L){
//            return "0";
//        }

        if(numbersStringArr[0].equals("0")){  //위에 거랑 뭐가 다르지?
            return "0";
        }

        return answer;


    }

}