package week5.Yoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//59352KB 1772ms
public class Yoo1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a); //이분탐색을 위한 정렬

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(binarySearch(a, key) >= 0){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }

    private static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) /2;
            if(key < a[mid]){
                hi = mid-1;
            }else if(key > a[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
