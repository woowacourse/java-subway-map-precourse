package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Info {
    private static final String INFO = "\n[INFO] ";

    public static void printIntervals() {
        System.out.print("\n## 지하철 노선도");
        for (Line line : LineRepository.lines().keySet()) {
            System.out.println(INFO + line);
            System.out.print("---");
            for (Station station : LineRepository.lines().get(line)) {
                System.out.print(INFO + station);
            }
            System.out.println();
        }
    }

    public static void printStations() {
        System.out.print("\n## 역 목록");
        for (Station station : StationRepository.stations()) {
            System.out.print(INFO + station);
        }
        System.out.println();
    }

    public static void printStationRegistered(String stationName) {
        System.out.println(INFO + stationName + "이 등록되었습니다.");
    }

    public static void printStationDeleted(String stationName) {
        System.out.println(INFO + stationName + "이 삭제되었습니다.");
    }
}
