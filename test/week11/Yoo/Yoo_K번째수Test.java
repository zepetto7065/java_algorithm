package week11.Yoo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Yoo_K번째수Test {

    private int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{1, 5, 2, 6, 3, 7, 4};
    }

    @Test
    @DisplayName("array를 index에 따라 slice하는 테스트")
    void arraySplitTest() {
        //given
        int start = 2;
        int end = 5;
        //when
        int[] slicedArray = Arrays.copyOfRange(array, start - 1, end );
        //then
        Assertions.assertThat(slicedArray).isEqualTo(new int[]{5, 2, 6, 3});
    }

    @Test
    @DisplayName("Array 정렬 테스트")
    void arraySortTest(){
        Arrays.sort(array);
        Assertions.assertThat(array).isEqualTo(new int[]{1,2,3,4,5,6,7});
    }
}