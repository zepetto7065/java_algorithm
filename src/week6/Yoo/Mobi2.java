package week6.Yoo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Mobi2 {

    static boolean[] check;
    static int[][] map;

    public static void main(String[] args) {
        int T[] = new int[]{0, 0, 1, 1};
        int A[] = new int[]{2};
        System.out.println(solutions(T, A));
    }

    private static int solutions(int[] T, int[] A) {
        map = new int[T.length][T.length];
        for (int i = 0; i < T.length; i++) {
            map[i][T[i]] = 1;
        }
        check = new boolean[T.length];
        List<Integer> aList = Arrays.stream(A).boxed()
                .collect(Collectors.toList());

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 1;

        while(!q.isEmpty()){
            int out = q.poll();
            check[out] = true;

            for(int i = 0;i < T.length; i++){
                if(map[i][out] == 1 && check[i] == false ){
                    //안배워도 되는 스킬

                    q.offer(i);
                    check[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
