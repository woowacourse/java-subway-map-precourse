package subway.view;

import java.util.List;
import java.util.Optional;
import subway.domain.Station;

public class LogMessage {
    private static final String PREFIX = "[INFO] ";
    private static final String END_MESSAGE = "종료합니다.\n";
    private static final String BACK_MESSAGE = "메인화면으로 돌아갑니다.\n";
    private static final String SUCCESS_TO_REGISTER_STATION_MESSAGE = "지하철 역이 등록되었습니다.\n";

    public static void printBackToMainScreen() {
        System.out.println(PREFIX + BACK_MESSAGE);
    }

    public static void printSuccessToRegisterStation() {
        System.out.println(PREFIX + SUCCESS_TO_REGISTER_STATION_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(PREFIX + END_MESSAGE);
    }

    public static void printStationList(List<Station> stations) {
        stations.stream()
            .map(Station::getName)
            .forEach(station -> System.out.println(PREFIX + station));
        System.out.println();
    }
}
