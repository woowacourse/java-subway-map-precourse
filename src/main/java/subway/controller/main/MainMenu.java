package subway.controller.main;

import subway.controller.ControllerContainer;
import subway.exception.InvalidFunctionException;
import subway.view.output.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

enum MainMenu {

    STATION_MANAGEMENT("1", "역 관리", () -> {
        ControllerContainer.getStationManagementController().run();
    }),
    LINE_MANAGEMENT("2", "노선 관리", () -> {
        ControllerContainer.getLineManagementController().run();
    }),
    SECTION_MANAGEMENT("3", "구간 관리", () -> {
        ControllerContainer.getSectionManagementController().run();
    }),
    PRINT_SUBWAY_MAP("4", "지하철 노선도 출력", () -> {
        String routeMap = ControllerContainer.getMainMenuController().getRouteMap();
        OutputView.print(routeMap);
    }),
    EXIT("Q", "종료", null);

    private final static String HEADER = "## 메인 화면";
    private final static String DELIMITER = ". ";

    String order;
    String menuName;
    Runnable function;

    MainMenu(String order, String menuName, Runnable function) {
        this.order = order;
        this.menuName = menuName;
        this.function = function;
    }

    public static String toMenuString() {
        List<String> menuList = Arrays.stream(MainMenu.values())
                .map(menu -> String.join(DELIMITER, String.valueOf(menu.order), menu.menuName))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();
        output.add(HEADER);
        output.addAll(menuList);

        return String.join(System.lineSeparator(), output);
    }

    public static Runnable find(String input) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> Objects.equals(menu.order, input))
                .findAny()
                .orElseThrow(() -> new InvalidFunctionException())
                .function;
    }
}
