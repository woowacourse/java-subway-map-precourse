package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class Info {
    private static final String INFO = "[INFO] ";

    public static void printIntervals() {
        for (Line line : LineRepository.lines().keySet()) {
            System.out.println(INFO+line);
            System.out.println("---");
            for (Station station : LineRepository.lines().get(line)) {
                System.out.println(INFO+station);
            }
            System.out.println();
        }
    }
}
