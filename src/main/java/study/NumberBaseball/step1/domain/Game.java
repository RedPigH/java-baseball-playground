package study.NumberBaseball.step1.domain;

import java.util.List;
import java.util.function.Predicate;

public class Game {
    static int ball_cnt = 0;
    static int strike_cnt = 0;

    public static String play(List<Integer> answer, List<Integer> input) {
        String playresult = "";

        strike_cnt = orderCnt(answer, input);
        ball_cnt = containCnt(answer, input) - strike_cnt;

        if (ball_cnt > 0) {
            playresult += ball_cnt + "볼";
        }
        if (strike_cnt > 0) {
            playresult += strike_cnt + "스트라이크";
        }
        if (playresult.equals("")) {
            playresult += "낫싱";
        }

        return playresult;
    }

    public static int orderCnt(List<Integer> answer, List<Integer> input) {
        int cnt = 0;

        for (int i = 0; i < input.size(); i++) {
            if (answer.get(i) == input.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int containCnt(List<Integer> answer, List<Integer> input) {

        return (int) input.stream().filter(n -> answer.stream().anyMatch(Predicate.isEqual(n))).count();

    }
}
