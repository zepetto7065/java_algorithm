import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week4.Yun.Yun_newIdRecommendation;

class Yun_newIdRecommendationTest {

    Yun_newIdRecommendation q;

    @BeforeEach
    void setUp() {
        q = new Yun_newIdRecommendation();
    }

    @Test
    void test1() {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = "bat.y.abcdefghi";
        Assertions.assertEquals(result, q.solution(new_id));
    }

    @Test
    void test2() {
        String new_id = "z-+.^.";
        String result = "z--";
        Assertions.assertEquals(result, q.solution(new_id));
    }

    @Test
    void test3() {
        String new_id = "=.=";
        String result = "aaa";
        Assertions.assertEquals(result, q.solution(new_id));
    }

    @Test
    void test4() {
        String new_id = "123_.def";
        String result = "123_.def";
        Assertions.assertEquals(result, q.solution(new_id));
    }

    @Test
    void test5() {
        String new_id = "abcdefghijklmn.p";
        String result = "abcdefghijklmn";
        Assertions.assertEquals(result, q.solution(new_id));
    }

}