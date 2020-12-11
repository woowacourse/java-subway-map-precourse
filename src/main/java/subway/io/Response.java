package subway.io;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import subway.Scene;
import subway.view.Command;
import subway.view.View;

public class Response {
    private static final String HEADLINE_MESSAGE_FORMAT = "## %s\n";
    private static final String MENU_FORMAT = "%s. %s\n";
    private static final String INFO_FORMAT = "[INFO] %s\n\n";
    public static final String COMMAND_REQUEST_MESSAGE = "원하는 기능을 선택하세요.";
    public static final String STATION_TO_REGISTER_REQUEST_MESSAGE = "등록할 역 이름을 입력하세요.";
    public static final String STATION_TO_REMOVE_REQUEST_MESSAGE = "삭제할 역 이름을 입력하세요.";
    public static final String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    public static final String STATION_REMOVAL_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    private final PrintStream printStream;

    public Response(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printMenus(Scene scene) {
        View view = scene.getCurrentView();
        printHeadlineMessage(view.getTitle());
        LinkedHashMap<String, Command> menus = view.getMenus();
        for (String input : menus.keySet()) {
            printStream.printf(MENU_FORMAT, input, menus.get(input).getMessage());
        }
        printStream.println();
    }

    public void printEmptyMessage() {
        printStream.println();
    }

    public void printHeadlineMessage(String message) {
        printStream.printf(HEADLINE_MESSAGE_FORMAT, message);
    }

    public void printInfoMessage(String message) {
        printStream.printf(INFO_FORMAT, message);
    }
}
