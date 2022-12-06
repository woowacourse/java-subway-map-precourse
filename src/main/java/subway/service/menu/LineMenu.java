package subway.service.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.controller.MainController;
import subway.service.LineService;
import subway.view.OutputView;

public enum LineMenu implements Menu {

    PRINT_LINE("##", " 노선 관리 화면", null),
    SELECT_LINE_UPDATE("1", ". 노선 등록", new LineService()::addLineLogic),
    SELECT_LINE_REMOVE("2", ". 노선 삭제", new LineService()::removeLineLogic),
    SELECT_PRINT_LINE_LIST("3", ". 노선 조회", new OutputView()::printLineList),
    BACK("B", ". 돌아가기", new MainController()::runMenu);

    private static final String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
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

    public static List<String> getMenu() {
        return Arrays.stream(LineMenu.values())
                .map(e -> e.getNumber() + e.getMessage())
                .collect(Collectors.toList());
    }

    public static void callLineFunction(String input) {
        LineMenu result = Arrays.stream(LineMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
        result.getFunction()
                .run();
    }
}
