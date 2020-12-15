package subway.controller.function;

import subway.controller.LineController;
import subway.controller.MainController;
import subway.controller.SectionController;
import subway.controller.StationController;

import java.util.Arrays;
import java.util.Objects;

public enum MainFunction implements Function {
    MANAGE_STATION("1", "역 관리", StationController::run),
    MANAGE_LINE("2", "노선 관리", LineController::run),
    MANAGE_SECTION("3", "구간 관리", SectionController::run),
    PRINT_SUBWAY_MAP("4", "지하철 노선도 출력", SectionController::sections),
    QUIT("Q", "종료", MainController::run);

    private String code;
    private String title;
    private Runnable function;

    MainFunction(String code, String title, Runnable function) {
        this.code = code;
        this.title = title;
        this.function = function;

    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Runnable getFunction() {
        return function;
    }

    public static void callBy(String code) {
        Arrays.stream(MainFunction.values())
                .filter(function -> Objects.equals(function.getCode(), code))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
