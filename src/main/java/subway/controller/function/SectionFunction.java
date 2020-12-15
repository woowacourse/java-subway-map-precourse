package subway.controller.function;

import subway.controller.MainController;
import subway.controller.SectionController;

import java.util.Arrays;
import java.util.Objects;

public enum SectionFunction implements Function {
    REGISTER_SECTION("1", "구간 등록", SectionController::addSection),
    DELETE_SECTION("2", "구간 삭제", SectionController::deleteSection),
    BACK("B", "돌아가기", MainController::redirect);

    private String code;
    private String title;
    private Runnable function;

    SectionFunction(String code, String title, Runnable function) {
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
        Arrays.stream(SectionFunction.values())
                .filter(function -> Objects.equals(function.getCode(), code))
                .findAny()
                .get()
                .getFunction()
                .run();
    }
}
