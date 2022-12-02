package subway.controller.menu;

import java.util.Arrays;
import java.util.Objects;

public enum StationMenu implements Menu {
    PRINT_STATION("##", " 역 관리 화면", null),
    SELECT_STATION_UPDATE("1", ". 역 등록", null),
    SELECT_STATION_REMOVE("2", ". 역 삭제", null),
    SELECT_PRINT_STATION_LIST("3", ". 역 조회", null),
    BACK("B", ". 돌아가기", null);

    private final String number;
    private final String message;
    private final Runnable function;

    StationMenu(String number, String message, Runnable function) {
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
        Arrays.stream(StationMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
