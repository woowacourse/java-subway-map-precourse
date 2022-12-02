package subway.controller.menu;

import java.util.Arrays;
import java.util.Objects;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;

public enum MainMenu implements Menu {

    PRINT_MAIN("##"," 메인 화면",null),
    SELECT_STATION_MANAGEMENT("1",". 역 관리",StationController::stationRun),
    SELECT_LINE_MANAGEMENT("2",". 노선 관리",LineController::lineRun),
    SELECT_SECTION_MANAGEMENT("3",". 구간 관리",SectionController::sectionRun),
    PRINT_SUBWAY_MAP("4",". 지하철 노선도 출력",null),
    QUIT("Q",". 종료",null);

    private final String number;
    private final String message;
    private final Runnable function;

    MainMenu(String number, String message, Runnable function) {
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
        MainMenu result = Arrays.stream(MainMenu.values())
                .filter(function -> Objects.equals(function.getNumber(), input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
        result.getFunction()
                .run();
    }
}
