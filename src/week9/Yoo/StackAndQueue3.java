package week9.Yoo;


import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭
//https://minhamina.tistory.com/241
public class StackAndQueue3 {
    public static void main(String[] args) {
        int bridge_length =2;
        int weight =10;
        int[] truck_weights = new int[]{7,4,5,6};
        solution(bridge_length, weight, truck_weights);
    }

    private static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for(int i = 0; i< truck_weights.length;i++){
            int truck = truck_weights[i];

            while(true){
                //다리에 트럭이 없을때
                if(queue.isEmpty()){
                    queue.add(truck);
                    sum+=truck;
                    time++;

                    break;
                }else if(queue.size() == bridge_length){
                    //다리 길이만큼 트럭이 다찼을때
                    sum -= queue.poll();
                }else{
                    if(sum+truck <= weight){
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }else{
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}
