package week3.Kim;

import java.io.*;

public class Kim_10989 {
    //수 정렬하기3 : https://www.acmicpc.net/problem/10989  - 카운팅정렬(296988KB, 1760ms) X
    //수의 범위가 극단적으로 클 경우, 메모리 낭비 심함
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int val;
        for (int i=0;i<N;i++) {
            val = Integer.parseInt(br.readLine());
            arr[val]++;
        }
        for(int i=1;i<=10000;i++){
            for(int j=0;j<arr[i];j++){
                bw.write(i+"\n");
            }
        }
        bw.flush();
    }

/*    private static void mergeSort(int start, int end) {
        if(start<end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }

    private static void merge(int start, int mid, int end) {
        int i, j, k, l;
        i = start;
        j = mid + 1;
        k = start;

        while (i <= mid && j <= end) {
            if(arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=end)
            temp[k++]=arr[j++];

        for(l=start;l<k;l++) {
            arr[l] = temp[l];
        }
    }*/
}
