package study.numberbaseball.step1.view;

import study.numberbaseball.step1.util.GameUtil;

import java.util.Scanner;

public class OutputView {

    int operation;

    public void endEvent() {
        Scanner scan = new Scanner(System.in);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        operation = scan.nextInt();
        if (!GameUtil.checkOperation(operation)) {
            throw new RuntimeException("not valid operation");
        }
    }

    public int getOperation() {
        return this.operation;
    }

}
