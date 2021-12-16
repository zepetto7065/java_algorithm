package week3.Yoo;

import java.util.Arrays;
import java.util.Comparator;

public class YooCompare2 {
    public static void main(String[] args) {
        sortTwoNum();
    }

    //이차원 배열 비교하기
    private static void sortTwoNum() {
        int[][] array = {{1,2},{1,3},{1,1}};

        Arrays.sort(array, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return  o1[1] - o2[1];
                }else{
                    return  o1[0] - o2[0];
                }
            }
        });

        for(int i =0; i< array.length;i++){
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }
}
