package week6.Yoo;

import java.util.LinkedList;
import java.util.Queue;

public class Mobi2 {

    static boolean[] check;
    static int[][] map;

    public static void main(String[] args) {
        int T[] = new int[]{0,0,1,1};
        int A[] = new int[]{2};
        solutions(T,A);
    }

    private static void solutions(int[] T, int[] A) {
        map = new int[T.length][T.length];
        for(int i =0; i< T.length ; i++){
            map[i][T[i]] = 1;
        }

        check = new boolean[T.length];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int count = 1; //root 방문 체크

        while(!q.isEmpty()){
            int out = q.poll();
            check[out] = true; //방문체크

            for(int i = 0; i < T.length; i++){
                if(map[i][out] == 1 && check[i] == false){
                    q.offer(i);
                    check[i] = true;
                    count++;
                }
            }

        }

        System.out.println(count);

    }
}
