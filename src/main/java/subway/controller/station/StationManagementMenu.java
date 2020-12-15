package subway.controller.station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import subway.controller.ControllerContainer;
import subway.exception.InvalidFunctionException;

public enum StationManagementMenu {


    STATION_REGISTER("1", "역 등록", () -> {
        ControllerContainer.getStationManagementController().registerStation();
    }),
    STATION_DELETE("2", "역 삭제", () -> {
        ControllerContainer.getStationManagementController().deleteStation();
    }),
    STATION_SCAN("3", "역 조회", () -> {
        ControllerContainer.getStationManagementController().viewStations();
    }),
    BACK("B", "돌아가기", null),
    ;

    private static final String HEADER = "\n## 역 관리 화면";
    private final static String DELIMITER = ". ";

    String order;
    String menuName;
    Runnable function;

    StationManagementMenu(String order, String menuName, Runnable function) {
        this.order = order;
        this.menuName = menuName;
        this.function = function;
    }

    public static String toMenuString() {
        List<String> menuList = Arrays.stream(StationManagementMenu.values())
                .map(menu -> String.join(DELIMITER, String.valueOf(menu.order), menu.menuName))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();
        output.add(HEADER);
        output.addAll(menuList);

        return String.join(System.lineSeparator(), output);
    }

    public static Runnable find(String input) {
        return Arrays.stream(StationManagementMenu.values())
                .filter(menu -> Objects.equals(menu.order, input))
                .findAny()
                .orElseThrow(() -> new InvalidFunctionException())
                .function;
    }

}
