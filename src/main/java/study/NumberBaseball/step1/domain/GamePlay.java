package study.numberbaseball.step1.domain;

import study.numberbaseball.step1.view.InputView;
import study.numberbaseball.step1.view.OutputView;
import study.numberbaseball.step1.util.GameUtil;

import java.util.List;

public class GamePlay {

    public static void main(String[] args) {
        boolean retry = true;

        while (retry) {
            retry = excute();
        }
    }

    private static boolean excute() {
        Answer answer = new Answer();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Integer> computer = answer.makeAnswer();
        System.out.println(computer);

        String playresult;

        while (true) {
            inputView.startEvent();
            playresult = Game.play(computer, inputView.getInpulist());
            System.out.println(playresult);
            if (playresult.equals("3스트라이크")) {
                break;
            }
        }
        outputView.endEvent();

        if (!GameUtil.checkOperation(outputView.getOperation())) {
            throw new RuntimeException("not valid operation");
        }

        if (outputView.getOperation() == 1) {
            return true;
        }

        return false;
    }
}
