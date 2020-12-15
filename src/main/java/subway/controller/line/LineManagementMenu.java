package subway.controller.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import subway.controller.ControllerContainer;
import subway.exception.InvalidFunctionException;

public enum LineManagementMenu {

    LINE_REGISTER("1", "노선 등록", () -> {
        ControllerContainer.getLineManagementController().registerLine();
    }),
    LINE_DELETE("2", "노선 삭제", () -> {
        ControllerContainer.getLineManagementController().deleteLine();
    }),
    LINE_SCAN("3", "노선 조회", () -> {
        ControllerContainer.getLineManagementController().viewLine();
    }),
    BACK("B", "돌아가기", null),
    ;

    private static final String HEADER = "\n## 노선 관리 화면";
    private final static String DELIMITER = ". ";

    String order;
    String menuName;
    Runnable function;

    LineManagementMenu(String order, String menuName, Runnable function) {
        this.order = order;
        this.menuName = menuName;
        this.function = function;
    }

    public static String toMenuString() {
        List<String> menuList = Arrays.stream(LineManagementMenu.values())
                .map(menu -> String.join(DELIMITER, String.valueOf(menu.order), menu.menuName))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();
        output.add(HEADER);
        output.addAll(menuList);

        return String.join(System.lineSeparator(), output);
    }

    public static Runnable find(String input) {
        return Arrays.stream(LineManagementMenu.values())
                .filter(menu -> Objects.equals(menu.order, input))
                .findAny()
                .orElseThrow(() -> new InvalidFunctionException())
                .function;
    }

}
