package subway.controller.function;

import subway.controller.LineController;
import subway.controller.MainController;

import java.util.Arrays;
import java.util.Objects;

public enum LineFunction implements Function {
    REGISTER_LINE("1", "노선 등록", LineController::addLine),
    DELETE_LINE("2", "노선 삭제", LineController::deleteLineByName),
    SEARCH_LINE("3", "노선 조회", LineController::lines),
    BACK("B", "돌아가기", MainController::redirect);

    private String code;
    private String title;
    private Runnable function;

    LineFunction(String code, String title, Runnable function) {
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
        Arrays.stream(LineFunction.values())
                .filter(function -> Objects.equals(function.getCode(), code))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
