package subway.view;

import java.util.ArrayList;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {

    public static void printAnnouncement(final String Ann) {
        System.out.println("## " + Ann);
    }

    public static void printInfo(final String info) {
        System.out.println("[INFO] " + info);
    }

    public static void printError(final String error) {
        System.out.println("[ERROR] " + error);
    }

    public static void printStations() {
        ArrayList<Station> stations = StationRepository.getAllStations();
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

    public static void printLines() {
        ArrayList<Line> lines = LineRepository.getAllLines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }
}
