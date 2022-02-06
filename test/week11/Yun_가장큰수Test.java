package week11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Yun_가장큰수Test {

    Yun_가장큰수 q;

    @BeforeEach
    void setUp() {
        q= new Yun_가장큰수();
    }

    @Test
    void test1(){
        assertEquals(q.solution(new int[]{1,0,10,100,0,10}),new String("1101010000"));
    }
}