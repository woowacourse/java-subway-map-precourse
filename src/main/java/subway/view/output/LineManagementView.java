package subway.view.output;

import subway.domain.line.Line;
import subway.domain.line.LineName;
import subway.view.util.Formatter;

import java.util.List;

public class LineManagementView extends ScreenView {
    private static final String LINE = "노선";
    private static final String NAME = "이름";
    private static final String UPLINE_TERMINAL = "상행 종점역";
    private static final String DOWNLINE_TERMINAL = "상행 종점역";
    private static final String LINE_HEADER = "## 노선 목록";
    private static final String LINE_REGISTER_START_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String LINE_REGISTER_FINISH_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE_MESSAGE = "## 삭제할 노선 이름을 입력하세요..";
    private static final String LINE_DELETE_FINISH_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String LINE_MANAGEMENT_MENU = "## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n" +
            "3. 노선 조회\nB. 돌아가기\n";


    public static void printMenu() {
        System.out.println(LINE_MANAGEMENT_MENU);
        System.out.println();
    }

    public static void printRegisterMessage() {
        System.out.println(LINE_REGISTER_START_MESSAGE);
    }

    public static void printLineNameInputMessage() {
        System.out.println(registerFunction(LINE, NAME));
    }

    public static void printDeleteMessage() {
        System.out.println(LINE_DELETE_MESSAGE);

    }

    public static void printDeleteFinishMessage() {
        System.out.println(LINE_DELETE_FINISH_MESSAGE);
    }

    public static void printUpLineNameInputMessage() {
        System.out.println(registerFunction(LINE, UPLINE_TERMINAL));
    }

    public static void printDownLineNameInputMessage() {
        System.out.println(registerFunction(LINE, DOWNLINE_TERMINAL));
    }

    public static void printLineRegisteredFinishMessage() {
        System.out.println(Formatter.Info(LINE_REGISTER_FINISH_MESSAGE));
    }

    public static void printLineList(List<Line> list) {
        System.out.println(LINE_HEADER);

        list.stream()
                .map(Line::getName)
                .map(LineName::toString)
                .map(Formatter::Info)
                .forEach(System.out::println);

        System.out.println();
    }
}
