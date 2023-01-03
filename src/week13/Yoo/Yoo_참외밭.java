package week13.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Yoo_참외밭 {
    static int k;
    static List<Integer> width;
    static List<Integer> length;
    static List<Integer> temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        width = new ArrayList<>();
        length = new ArrayList<>();
        temp = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if (direction == 1 || direction == 2) width.add(target);
            if (direction == 3 || direction == 4) length.add(target);
            temp.add(target);
        }

        int area = getArea();
        System.out.println(area * k);
    }

    //큰거에서 작은걸 빼자(x) -> 제일 작은게 튀어 나올 수 있음.
    //temp.get(i-1) + temp.get(i+1) 이 너비나 높이어야함.
    public static int getArea() {
        Collections.sort(width);
        Collections.sort(length);

        int maxArea = width.get(width.size() - 1) * length.get(length.size() - 1);
        int minLength = 0;
        int minWidth = 0;

        for(int i = 1; i < temp.size()-1; i++){
            int tempSize = temp.get(i-1) + temp.get(i+1); //비교 대상
            if(width.get(width.size()-1) == tempSize) minWidth = temp.get(i);
            if(length.get(length.size()-1) == tempSize) minLength = temp.get(i);
        }

        return maxArea - (minLength * minWidth);
    }
}
