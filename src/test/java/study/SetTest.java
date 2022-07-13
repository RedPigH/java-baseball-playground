package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 확인")
    void size(){
        assertEquals(3, numbers.size());
    }

    @Test
    @DisplayName("Set Contain Method를 통한 값 존재 여부 확인")
    void contains(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set Contain Method를 통한 값 존재 여부 확인 (중복 제거)")
    void improvedcontains(int num){
        //assertThat(numbers.contains(num)).isTrue();
        assertTrue(numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource({"1, true","2, true", "3, true","4, false","5, false"})
    void containstruefalse(int num, boolean bool){
        assertThat(numbers.contains(num)).isEqualTo(bool);
    }

}
