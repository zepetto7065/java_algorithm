package week11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week11.Yun.Yun_H_Index;

import static org.junit.jupiter.api.Assertions.*;

class Yun_H_IndexTest {

    Yun_H_Index q;

    @BeforeEach
    void setUp() {
        q = new Yun_H_Index();
    }

    @Test
    void test1(){
        assertEquals(q.solution(new int[]{10,50,100}),3);
    }
}