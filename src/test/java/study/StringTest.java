package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    void charat(){
        /*Require 3*/
    }
}

