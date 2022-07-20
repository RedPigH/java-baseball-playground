package study.NumberBaseball.step1.util;

import java.util.List;

public class GameUtil {

    static int SIZE = 3;
    public static boolean NumVaildate(int i) {
        return Integer.toString(i).matches("[1-9]");
    }

    public static boolean isExist(List<Integer> list) {
        return list.size() != list.stream().distinct().count();
    }

    public static boolean SizeVaildate(List<Integer> list) {
        return list.size() == SIZE;
    }

    public static boolean CheckOperation(int i){
        return (i == 1 || i == 2);
    }
}
