package subway.view;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.selector.menu.Menu;
import subway.domain.station.Station;

public class OutputView {

    private static final String INFORMATION_TAG = "[INFO]";
    private static final String LINE_STATION_SEPARATOR = "---";
    private static final String SCREEN_MESSAGE_START = "\n## ";
    private static final String SCREEN_MESSAGE_END = " 화면";
    private static final String ID_SEPARATOR = ". ";
    MessageView messageView = new MessageView();

    public void printScreen(Menu menu) {
        System.out.println(SCREEN_MESSAGE_START + menu + SCREEN_MESSAGE_END);
        printMenus(menu);
        printItems(menu);
        System.out.println();
    }

    private void printMenus(Menu menu) {
        for (String key : menu.getMenus().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getMenus().get(key));
        }
    }

    private void printItems(Menu menu) {
        for (String key : menu.getItems().keySet()) {
            System.out.println(key + ID_SEPARATOR + menu.getItems().get(key));
        }
    }

    public void printStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println(INFORMATION_TAG + " " + station.getName());
        }
    }

    public void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(INFORMATION_TAG + " " + line.getName());
        }
    }

    public void printSubwayLineMap() {
        List<Line> lines = LineRepository.lines();
        messageView.printSubwayLineMapMessage();

        for (Line line : lines) {
            System.out.println(INFORMATION_TAG + " " + line.getName());
            System.out.println(INFORMATION_TAG + " " + LINE_STATION_SEPARATOR);
            printStations(line.stations());
            System.out.println();
        }
    }

}
