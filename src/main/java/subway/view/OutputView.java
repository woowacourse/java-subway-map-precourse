package subway.view;


import java.util.ArrayList;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;

public class OutputView implements Message {

    private static final String TITLE = "## ";
    private static final String INFO = "[INFO] ";
    private static final String ERROR = "[ERROR] ";
    private static final String SEPARATOR = "---";


    public static void printAnnouncement(final String message) {
        System.out.println(TITLE + message);
        breakLine();
    }

    public static void printInfo(final String message) {
        System.out.println(INFO + message);
        breakLine();
    }

    public static void printError(final String message) {
        System.out.println(ERROR + message);
        breakLine();
    }

    public static void displaySelection() {
        printAnnouncement(DISPLAY_SELECTION);
    }

    public static void displayMain() {
        printAnnouncement(DISPLAY_MAIN);
    }

    public static void displayStationManagement() {
        printAnnouncement(DISPLAY_STATION_MANAGEMENT);
    }

    public static void displayLineManagement() {
        printAnnouncement(DISPLAY_LINE_MANAGEMENT);
    }

    public static void displaySectionManagement() {
        printAnnouncement(DISPLAY_SECTION_MANAGEMENT);
    }

    public static void printStations() {
        ArrayList<Station> stations = StationRepository.getAllStations();
        printAnnouncement(DISPLAY_STATION_LIST);
        for (Station station : stations) {
            System.out.println(INFO + station.getName());
        }
        breakLine();
    }

    public static void printLines() {
        ArrayList<Line> lines = LineRepository.getAllLines();
        printAnnouncement(DISPLAY_LINE_LIST);
        for (Line line : lines) {
            System.out.println(INFO + line.getName());
        }
        breakLine();
    }

    public static void printWholeSection() {
        printAnnouncement(DISPLAY_WHOLE_SECTION);
        ArrayList<Line> lines = LineRepository.getAllLines();
        for (Line line : lines) {
            System.out.println(INFO + line.getName());
            System.out.println(INFO + SEPARATOR);
            for (Station station : line.getStations()) {
                System.out.println(INFO + station.getName());
            }
            breakLine();
        }
    }

    private static void breakLine() {
        System.out.println();
    }
}
