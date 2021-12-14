package week3.Kim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Kim_1427 {
    //소트인사이드 : https://www.acmicpc.net/problem/1427 - 11580kb	92ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<line.length();i++){
            arr.add(line.charAt(i)-'0');
        }
        Collections.sort(arr,Collections.reverseOrder());
        for(int i=0;i<arr.size();i++) System.out.print(arr.get(i));
    }
}
