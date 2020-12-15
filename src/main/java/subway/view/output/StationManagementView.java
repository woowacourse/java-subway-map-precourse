package subway.view.output;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.view.util.Formatter;

import java.util.List;

public class StationManagementView extends ScreenView {
    private static final String HEADER = "## 역 목록";
    private static final String FUNCTION = "역";
    private static final String REGISTER_FINISH_MESSAGE = Formatter.Info("지하철 역이 등록되었습니다.");
    private static final String DELETE_FINISH_MESSAGE = Formatter.Info("지하철 역이 삭제되었습니다.");

    public static void printDeleteMessage() {
        System.out.println(deleteFunction(FUNCTION));
    }

    public static void printRegisterMessage() {
        System.out.println(registerFunction(FUNCTION));
    }

    public static void printRegisterFinishMessage() {
        System.out.println(REGISTER_FINISH_MESSAGE);
    }

    public static void printDeleteFinishMessage() {
        System.out.println(DELETE_FINISH_MESSAGE);
    }

    public static void printStationList(List<Station> list) {
        System.out.println(HEADER);

        list.stream()
                .map(Station::getName)
                .map(StationName::toString)
                .map(Formatter::Info)
                .forEach(System.out::println);

        System.out.println();
    }
}
