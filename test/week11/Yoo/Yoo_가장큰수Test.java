package week11.Yoo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Yoo_가장큰수Test {

    int[] numbers;
    String[] strings;

    @BeforeEach
    void setUp() {
        numbers = new int[]{6, 10, 2};
        strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
    }

    @Test
    void comparatorTest() {
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        Assertions.assertThat(strings).isEqualTo(new String[]{"6", "2", "10"});
    }
}