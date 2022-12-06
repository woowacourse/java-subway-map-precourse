package subway.service.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import subway.controller.MainController;
import subway.service.StationService;
import subway.view.OutputView;

public enum StationMenu implements Menu {

    PRINT_STATION("##", " 역 관리 화면", null),
    SELECT_STATION_UPDATE("1", ". 역 등록", new StationService()::addStationLogic),
    SELECT_STATION_REMOVE("2", ". 역 삭제", new StationService()::removeStation),
    SELECT_PRINT_STATION_LIST("3", ". 역 조회", new OutputView()::printStationList),
    BACK("B", ". 돌아가기", new MainController()::runMenu);

    private static final String ERROR_MESSAGE = "선택할 수 없는 기능입니다.";
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

    public static List<String> getMenu() {
        return Arrays.stream(StationMenu.values())
                .map(e -> e.getNumber() + e.getMessage())
                .collect(Collectors.toList());
    }

    public static void callFunction(String input) {
        StationMenu result = Arrays.stream(StationMenu.values())
                .filter(e -> Objects.equals(e.getNumber(), input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE));
        result.getFunction()
                .run();
    }
}
