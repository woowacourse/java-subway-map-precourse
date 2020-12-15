package subway.controller.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import subway.controller.ControllerContainer;
import subway.exception.InvalidFunctionException;

public enum SectionManagementMenu {

    LINE_REGISTER("1", "구간 등록", () -> {
        ControllerContainer.getSectionManagementController().registerSection();
    }),
    LINE_DELETE("2", "구간 삭제", () -> {
        ControllerContainer.getSectionManagementController().deleteSection();
    }),
    BACK("B", "돌아가기", null),
    ;

    private static final String HEADER = "\n## 구간 관리 화면";
    private final static String DELIMITER = ". ";

    String order;
    String menuName;
    Runnable function;

    SectionManagementMenu(String order, String menuName, Runnable function) {
        this.order = order;
        this.menuName = menuName;
        this.function = function;
    }

    public static String toMenuString() {
        List<String> menuList = Arrays.stream(SectionManagementMenu.values())
                .map(menu -> String.join(DELIMITER, String.valueOf(menu.order), menu.menuName))
                .collect(Collectors.toList());

        List<String> output = new ArrayList<>();
        output.add(HEADER);
        output.addAll(menuList);

        return String.join(System.lineSeparator(), output);
    }

    public static Runnable find(String input) {
        return Arrays.stream(SectionManagementMenu.values())
                .filter(menu -> Objects.equals(menu.order, input))
                .findAny()
                .orElseThrow(() -> new InvalidFunctionException())
                .function;
    }

}
