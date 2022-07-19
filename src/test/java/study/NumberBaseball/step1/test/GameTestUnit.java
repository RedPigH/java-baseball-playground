package study.NumberBaseball.step1.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.NumberBaseball.step1.domain.Answer;
import study.NumberBaseball.step1.util.GameUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class GameTestUnit {

    @Test
    @DisplayName("1-9 범위의 숫자 여부 체크")
    void NumVaildate() {
        assertThat(GameUtil.NumVaildate(10)).isFalse();
    }

    @Test
    @DisplayName("숫자 중복 체크")
    void isExist(){
        List<Integer> list = new ArrayList<Integer>(Stream.of(1,2).collect(Collectors.toList()));
        assertThat(GameUtil.isExist(list, 2)).isTrue();
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
}
