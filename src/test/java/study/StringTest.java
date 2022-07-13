package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        /*Require 1-1*/
        String[] Require = "1,2".split(",");
        assertThat(Require).contains("1","2");

        /*Require 1-2*/
        String[] Require1 = "1".split(",");
        assertThat(Require1).containsExactly("1");
    }

    @Test
    void substring() {
        /*Require 2*/
        String Require2 = "(1,2)".substring(1,"(1,2)".length()-1);
        assertThat(Require2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자 확인 테스트")
    void charat(){
        /*Require 3*/
        String Require3 = "abc";
        int index = 3;
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            Require3.charAt(3);
        }, "index : " + index + " Size : " + Require3.length());
    }
}

