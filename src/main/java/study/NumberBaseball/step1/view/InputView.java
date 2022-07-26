package study.numberbaseball.step1.view;

import study.numberbaseball.step1.util.GameUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private String input;
    private int[] inputarr;
    private List<Integer> inputlist;
    private Scanner scan = new Scanner(System.in);

    public void startEvent() {
        System.out.println("숫자를 입력해 주세요 : ");
        input = scan.next();
        inputarr = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i : inputarr) {
            if (!GameUtil.numVaildate(i)) {
                throw new RuntimeException("not valid num");
            }
        }
        inputlist = Arrays.stream(inputarr).boxed().collect(Collectors.toList());
        if (!GameUtil.sizeVaildate(inputlist)) {
            throw new RuntimeException("not valid size");
        }
        if (GameUtil.isExist(inputlist)) {
            throw new RuntimeException("duplicate number");
        }
    }

    public List<Integer> getInpulist() {
        return this.inputlist;
    }
}
