package subway.view;

import static subway.utils.Message.ANN_PRINT_WHOLE_LINES;

import java.util.ArrayList;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;

public class OutputView implements Message {

    public static void printAnnouncement(final String Ann) {
        System.out.println("## " + Ann);
        breakLine();
    }

    public static void printInfo(final String info) {
        System.out.println("[INFO] " + info);
        breakLine();
    }

    public static void printError(final String error) {
        System.out.println("[ERROR] " + error);
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
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        breakLine();
    }

    public static void printLines() {
        ArrayList<Line> lines = LineRepository.getAllLines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }

    public static void printWholeSection() {
        printAnnouncement(ANN_PRINT_WHOLE_LINES);
        ArrayList<Line> lines = LineRepository.getAllLines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            for (Station station : line.getStations()) {
                System.out.println("[INFO] " + station.getName());
            }
            breakLine();
        }
    }

    private static void breakLine() {
        System.out.println("");
    }
}
