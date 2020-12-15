package subway.controller.function;

import subway.controller.MainController;
import subway.controller.StationController;

import java.util.Arrays;
import java.util.Objects;

public enum StationFunction implements Function {
    REGISTER_STATION("1", "역 등록", StationController::addStation),
    DELETE_STATION("2", "역 삭제", StationController::deleteStation),
    SEARCH_STATION("3", "역 조회", StationController::stations),
    BACK("B", "돌아가기", MainController::redirect);

    private String code;
    private String title;
    private Runnable function;

    StationFunction(String code, String title, Runnable function) {
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
        Arrays.stream(StationFunction.values())
                .filter(function -> Objects.equals(function.getCode(), code))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
