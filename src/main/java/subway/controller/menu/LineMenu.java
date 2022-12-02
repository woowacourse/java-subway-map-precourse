package subway.controller.menu;

import java.util.Arrays;
import java.util.Objects;

public enum LineMenu implements Menu {

    PRINT_LINE("##", ". 노선 관리 화면", null),
    SELECT_LINE_UPDATE("1", ". 노선 등록", null),
    SELECT_LINE_REMOVE("2", ". 노선 삭제", null),
    SELECT_PRINT_LINE_LIST("3", ". 노선 조회", null),
    BACK("B", ". 돌아가기", null);

    private final String number;
    private final String message;
    private final Runnable function;

    LineMenu(String number, String message, Runnable function) {
        this.number = number;
        this.message = message;
        this.function = function;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Runnable getFunction() {
        return function;
    }

    public static void callFunction(String input) {
        Arrays.stream(LineMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
