package week10.Yoo;

import java.util.ArrayList;
import java.util.List;

//https://skd03052.tistory.com/197
public class Yoo_소수찾기 {
    static int answer;
    static List<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[10];

    public static void main(String[] args) {
        String numbers = "17";
        int solution = Solution(numbers);
        System.out.println(solution);
    }

    private static int Solution(String numbers) {
        String tmp = "";
        for(int i = 0; i< numbers.length();i++){
            backTracking(numbers, tmp, i+1);
        }
        for(int i =0; i< arr.size(); i++){
            isPrime(arr.get(i));
        }
        return answer;
    }

    private static void isPrime(int n) {
        if(n==0 || n==1) return;
        for(int i= 2; i< n; i++){
            if(n%i == 0) return;
        }
        answer++;
    }

    private static void backTracking(String str, String tmp, int m){
        if(tmp.length() == m){
            int num = Integer.parseInt(tmp);
            if(!arr.contains(num)){
                arr.add(num);
                return;
            }else{
                for(int i= 0; i< str.length(); i++){
                    if(!check[i]){
                        check[i] = true;
                        tmp += str.charAt(i);
                        backTracking(str, tmp,m);
                        check[i] = false;
                        tmp = tmp.substring(0, tmp.length()-1);
                    }
                }
            }
        }
    }


}
