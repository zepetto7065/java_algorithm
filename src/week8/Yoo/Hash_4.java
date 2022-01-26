package week8.Yoo;

import java.util.*;

//베스트 앨범
public class Hash_4 {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        solution(genres, plays);
    }

    private static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        //장르 선정
        List<String> genres_ordered = new ArrayList<>();
        while(map.size() != 0){
            int max = -1;
            String max_key = "";
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt > max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            genres_ordered.add(max_key);
            map.remove(max_key);
        }

        //장르내 노래선정
        List<Music> result = new ArrayList<>();
        for(String gen : genres_ordered){
            List<Music> list = new ArrayList<>();
            for(int i =0; i < genres.length; i++){
                if(genres[i].equals(gen)){
                    list.add(new Music(gen, plays[i], i));
                }
            }
            Collections.sort(list, Comparator.comparingInt(o -> o.play));
            result.add(list.get(0));//1개는 무조건 넣기
            if(list.size()>1){
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        return answer;
    }

    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }
}
