package week13.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Yoo_단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Stack<String> stack = new Stack<>();
        String[] split = input.split("");
        int check = 0;
        StringBuilder result = new StringBuilder();

        // >  , < 순으로 나올경우?
        for (String s : split) {
            if("<".equals(s)){ //이 두경우에만 뒤집으면 됨
                check += 1;
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append("<");
            }else if(">".equals(s)){
                check -= 1;
                result.append(">");
            }else if(" ".equals(s)){ //이 두경우에만 뒤집으면 됨
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append(" ");
            }else{
                if(check == 0){
                    stack.push(s);
                }else{
                    result.append(s);
                }
            }
        }

        //남은 문자
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();
    }
}
