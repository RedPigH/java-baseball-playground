package study.NumberBaseball.step1.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Answer {
    private List<Integer> answer;
    public Answer(){
        this.answer = makeAnswer();
    }
    public List<Integer> makeAnswer(){
        answer = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(answer);
        return answer.subList(0,3);
    }
    public String toString() {
        return this.answer.toString();
    }
}
