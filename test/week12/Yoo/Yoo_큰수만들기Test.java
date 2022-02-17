package week12.Yoo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Yoo_큰수만들기Test {
    @Test
    @DisplayName("숫자 나누기 Test")
    void test(){
        //given
        String number =  "1924";

        //when
        String[] split = number.split("");

        //then
        Assertions.assertThat(split).hasSize(4);
    }
}