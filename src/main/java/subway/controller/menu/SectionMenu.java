package subway.controller.menu;

import java.util.Arrays;
import java.util.Objects;

public enum SectionMenu implements Menu {

    PRINT_SECTION("##", " 구간 관리 화면", null),
    UPDATE_SECTION("1", ". 구간 등록", null),
    REMOVE_SECTION("2", ". 구간 삭제", null),
    BACK("B", ". 돌아가기", null);

    private final String number;
    private final String message;
    private final Runnable function;

    SectionMenu(String number, String message, Runnable function) {
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
        Arrays.stream(SectionMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
