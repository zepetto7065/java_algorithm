package week8.Yoo;

import java.util.HashMap;
import java.util.Map;

//전화번호 목록
public class Hash_2 {
    public static void main(String[] args) {
        String[] phone_book = new String[]{"123", "456", "789"};
        System.out.println(solution(phone_book));
    }

    private static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }

        return answer;
    }

//    //하나씩 포함하는지 완전 탐색?
//    private static boolean solution(String[] phone_book) {
//        boolean answer = true;
//
//        for(int i =0; i < phone_book.length; i++){
//            for(int j = i+1; j < phone_book.length-i; j++){
//                if(phone_book[j].contains(phone_book[i])){
//                    return false;
//                }
//            }
//        }
//
//        return answer;
//    }
}
