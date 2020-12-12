package subway.io;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import subway.Scene;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Command;
import subway.view.View;

public class Response {
    private static final String HEADLINE_MESSAGE_FORMAT = "## %s\n";
    private static final String MENU_FORMAT = "%s. %s\n";
    private static final String INFO_FORMAT = "[INFO] %s\n";
    private static final String STATION_LIST_TITLE = "역 목록";
    private static final String LINE_LIST_TITLE = "노선 목록";
    public static final String COMMAND_REQUEST_MESSAGE = "원하는 기능을 선택하세요.";
    public static final String STATION_REGISTER_MESSAGE = "등록할 역 이름을 입력하세요.";
    public static final String STATION_REMOVAL_MESSAGE = "삭제할 역 이름을 입력하세요.";
    public static final String STATION_REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.\n";
    public static final String STATION_REMOVAL_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.\n";
    public static final String LINE_REGISTER_MESSAGE = "등록할 노선 이름을 입력하세요.";
    public static final String UPBOUND_STATION_REGISTER_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String DOWNBOUND_STATION_REGISTER_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String LINE_REGISTER_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.\n";
    public static final String LINE_REMOVAL_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    public static final String LINE_REMOVAL_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.\n";
    public static final String LINE_OF_SECTION_REGISTER_MESSAGE = "노선을 입력하세요.";
    public static final String STATION_OF_SECTION_REGISETER_MESSAGE = "역이름을 입력하세요.";
    public static final String INDEX_OF_SECTION_REGISTER_MESSAGE = "순서를 입력하세요.";
    public static final String SECTION_REGISTER_SUCCESS_MESSAGE = "구간이 등록되었습니다.\n";
    public static final String LINE_OF_SECTION_REMOVAL_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    public static final String STATION_OF_SECTION_REMOVAL_MESSAGE = "삭제할 구간의 역을 입력하세요.";

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

    public void printStations() {
        printHeadlineMessage(STATION_LIST_TITLE);
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            printInfoMessage(station.getName());
        }
        printStream.println();
    }

    public void printLines() {
        printHeadlineMessage(LINE_LIST_TITLE);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printInfoMessage(line.getName());
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
