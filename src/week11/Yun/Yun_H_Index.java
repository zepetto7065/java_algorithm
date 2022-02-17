package week11.Yun;
import java.util.Arrays;

public class Yun_H_Index {
    int[] citationsArr;
    int highestIndexLowerThanA = -1;
    public int solution(int[] citations) {
        citationsArr = citations;
        Arrays.sort(citationsArr);


        for (int i = citationsArr[citationsArr.length - 1]; i > 0; i--) {
            if (check(i)) {
                return i;
            }
        }

        return 0;
    }

    public boolean check(int a){
        for(int i=citationsArr.length-1; i>=0; i--){
            if(citationsArr[i]<a){
                highestIndexLowerThanA = i;
                break;
            }
            if(i==0){   //이거 안해주면 자꾸 highestIndexLowerThanA가 1로 바뀌는데 왜 그러지...?
                highestIndexLowerThanA = -1;
            }
        }

        int cntMoreThanA = citationsArr.length-1-highestIndexLowerThanA;

        if(cntMoreThanA < a){
            return false;
        }

        if(highestIndexLowerThanA+1 > a){
            return false;
        }
        return true;
    }
}