package week13.Yoo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Yoo_단어뒤집기2Test {

    @Test
    @DisplayName("거꾸로 뒤집기 Test")
    void reverseTest(){
        //given
//        String input = "baekjoon online judge";
        String input = "<open>tag<close>";
        String reverse = "";

        //when
        StringBuilder sb = new StringBuilder(input);
        reverse = sb.reverse().toString();

        //then
//        Assertions.assertThat(reverse).isEqualTo("egduj enilno noojkeab");
        Assertions.assertThat(reverse).isEqualTo("<open>gat<close>");
    }
}