package week4.Yoo;

public class NewIdRecommend {
    public static void main(String[] args) {
        String recommendId = solution("z-+.^.");
        System.out.println(recommendId);
    }

    private static String solution(String new_id) {

        //step1
        String targetStr = new_id.toLowerCase();

        //step2 - https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D
        targetStr = targetStr.replaceAll("[^a-z0-9-_.]", "");

        //step3
        while(targetStr.contains("..")){
            targetStr = targetStr.replace("..",".");
        }

        //step4
        if ( targetStr.length()>0 && targetStr.charAt(0) == '.') {
            targetStr = targetStr.substring(1);
        }

        if (targetStr.length()>0 && targetStr.charAt(targetStr.length()-1) == '.'  ) {
            targetStr = targetStr.substring(0,targetStr.length()-1);
        }

        //step5
        if(targetStr.length() == 0){
            targetStr = "a";
        }

        //step6
        if(targetStr.length() >= 16){
            targetStr = targetStr.substring(0,15);
            if(targetStr.charAt(targetStr.length()-1) =='.'){
                targetStr = targetStr.substring(0, targetStr.length()-1);
            }
        }

        //step7
        if(targetStr.length() <= 2){
            char lastWord = targetStr.charAt(targetStr.length() - 1);
            while(targetStr.length() < 3){
                targetStr += lastWord;
            }
        }

        return targetStr;
    }
}
