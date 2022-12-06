package subway.service.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.controller.MainController;
import subway.service.SectionService;

public enum SectionMenu implements Menu {

    PRINT_SECTION("##", " 구간 관리 화면", null),
    UPDATE_SECTION("1", ". 구간 등록", new SectionService()::addSectionLogic),
    REMOVE_SECTION("2", ". 구간 삭제", new SectionService()::removeSectionLogic),
    BACK("B", ". 돌아가기", new MainController()::runMenu);

    private static final String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
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

    public static List<String> getMenu() {
        return Arrays.stream(SectionMenu.values())
                .map(e -> e.getNumber() + e.getMessage())
                .collect(Collectors.toList());
    }

    public static void callSectionFunction(String input) {
        SectionMenu result = Arrays.stream(SectionMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
        result.getFunction()
                .run();
    }
}
