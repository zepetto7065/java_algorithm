package week6.Yoo;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bemin2 {
    public static void main(String[] args) {
        String param = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";
        solution(param);
    }

    private static String solution(String S) {
        StringTokenizer st = new StringTokenizer(S,"\n");
        Map<String, Long> map = new HashMap<>();
        map.put("music",0L);
        map.put("images",0L);
        map.put("movies",0L);
        map.put("other",0L);

        while(st.hasMoreElements()){
            String[] words = st.nextToken().split(" ");
            String[] nameValue = words[0].split("[.]");

            String extension = nameValue[nameValue.length-1];
            String flag = "";
            //확장자 구하기
            if("mp3".equals(extension) || "aac".equals(extension) || "flac".equals(extension)){
                flag = "music";
            }else if("jpg".equals(extension) || "bmp".equals(extension) || "gif".equals(extension)){
                flag = "images";
            }else if("mp4".equals(extension) || "avi".equals(extension) || "mkv".equals(extension)){
                flag = "movies";
            }else{
                flag = "other";
            }

            long cur = map.get(flag) + Long.parseLong(words[1].substring(0, words[1].length() - 1));
            map.put(flag, cur);
        }


        //출력
        StringBuilder sb = new StringBuilder();
        sb.append("music " + map.get("music")+"b\n")
                .append("images " + map.get("images")+"b\n")
                .append("movies " + map.get("movies")+"b\n")
                .append("other " + map.get("other")+"b");

        return sb.toString();
    }
}
