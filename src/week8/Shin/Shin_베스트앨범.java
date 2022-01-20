package week8.Shin;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 베스트 앨범: https://programmers.co.kr/learn/courses/30/lessons/42579
public class Shin_베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        for (int i : solution(genres, plays)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().stream().mapToInt(Music::getPlay).sum() - o1.getValue().stream().mapToInt(Music::getPlay).sum())
                .flatMap(e -> e.getValue().stream().sorted(Comparator.comparingInt(Music::getPlay).reversed()).limit(2))
                .mapToInt(Music::getIndex)
                .toArray();
    }

    static class Music {
        String genre;
        int play;
        int index;

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        public int getIndex() {
            return index;
        }
    }
}
