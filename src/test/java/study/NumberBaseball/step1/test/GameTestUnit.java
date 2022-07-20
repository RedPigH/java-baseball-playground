package study.NumberBaseball.step1.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.NumberBaseball.step1.domain.Answer;
import study.NumberBaseball.step1.domain.Game;
import study.NumberBaseball.step1.util.GameUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class GameTestUnit {

    @Test
    @DisplayName("1-9 범위의 숫자 여부 체크")
    void NumVaildate() {
        assertThat(GameUtil.NumVaildate(10)).isFalse();
        assertThat(GameUtil.NumVaildate(1)).isTrue();
    }

    @Test
    @DisplayName("숫자 중복 체크")
    void isExist(){
        List<Integer> list = new ArrayList<Integer>(Stream.of(1,2).collect(Collectors.toList()));
        assertThat(GameUtil.isExist(list)).isFalse();
    }

    @Test
    @DisplayName("입력값 길이 체크")
    void SizeVaildate() {
        List<Integer> list = new ArrayList<Integer>(Stream.of(1,2,3,4).collect(Collectors.toList()));
        assertThat(GameUtil.SizeVaildate(list)).isFalse();
    }

    @Test
    @DisplayName("정답 유효성 체크")
    void AnswerVaildate(){
        List<Integer> list = new Answer().makeAnswer();
        assertThat(list.stream().map(n -> n).allMatch(new HashSet<>()::add)).isTrue();  // 중복 체크
        assertThat(GameUtil.SizeVaildate(list)).isTrue();   // Size 체크
    }

    @Test
    @DisplayName("볼 개수 체크")
    void ContainCnt(){
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> input = Arrays.asList(3,4,2);
        assertEquals(2, Game.ContainCnt(answer,input));
    }

    @Test
    @DisplayName("스트라이크 개수 체크")
    void OrderCnt(){
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> input = Arrays.asList(4,2,3);
        assertEquals(2, Game.OrderCnt(answer,input));
    }

    @Test
    @DisplayName("결과값 체크")
    void isNothing(){
        List<Integer> answer = Arrays.asList(1,2,3);
        List<Integer> input = Arrays.asList(3,2,1);
        assertEquals(Game.play(answer,input),"2볼1스트라이크");

        List<Integer> answer1 = Arrays.asList(1,2,3);
        List<Integer> input1 = Arrays.asList(4,5,6);
        assertEquals(Game.play(answer1,input1),"낫싱");

        List<Integer> answer2 = Arrays.asList(1,2,3);
        List<Integer> input2 = Arrays.asList(2,3,1);
        assertEquals(Game.play(answer2,input2),"3볼");

        List<Integer> answer3 = Arrays.asList(1,2,3);
        List<Integer> input3 = Arrays.asList(1,2,3);
        assertEquals(Game.play(answer3,input3),"3스트라이크");
    }
}
