package study.NumberBaseball.step1.domain;

import study.NumberBaseball.step1.View.InputView;
import study.NumberBaseball.step1.View.OutputView;
import study.NumberBaseball.step1.util.GameUtil;

import java.util.List;

public class GamePlay {

    public static void main(String[] args) {
        boolean retry = true;

        while(retry){
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

        while(true){
            inputView.StartEvent();
            playresult = Game.play(computer,inputView.getInpulist());
            System.out.println(playresult);
            if(playresult.equals("3스트라이크")) break;
        }
        outputView.EndEvent();

        if(!GameUtil.CheckOperation(outputView.getOperation())){
            throw new RuntimeException("not valid operation");
        }

        if(outputView.getOperation() == 1) return true;

        return false;
    }
}
