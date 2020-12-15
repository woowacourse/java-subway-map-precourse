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
    private static final String BOUNDARY = "---";
    private static final String STATION_LIST_TITLE = "역 목록";
    private static final String LINE_LIST_TITLE = "노선 목록";
    private static final String MAP_TITLE = "지하철 노선도";

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

    public void printMap() {
        printHeadlineMessage(MAP_TITLE);
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            printInfoMessage(line.getName());
            printInfoMessage(BOUNDARY);
            printStationsInLine(line);
        }
    }

    public void printStationsInLine(Line line) {
        List<Station> stations = line.getStations();
        for (Station station : stations) {
            printInfoMessage(station.getName());
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
