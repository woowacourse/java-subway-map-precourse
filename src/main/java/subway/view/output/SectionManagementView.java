package subway.view.output;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.view.util.Formatter;

import java.util.List;

public class SectionManagementView extends ScreenView {
    private static final String LINE_INPUT_MESSAGE = "## 노선을 입력하세요.";
    private static final String STATION_NAME_INPUT_MESSAGE = "## 역이름을 입력하세요.";
    private static final String POSITION_INPUT_MESSAGE = "## 순서를 입력하세요.";
    private static final String DELETE_LINE_INPUT_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String DELETE_STATION_INPUT_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";

    private static final String REGISTER_FINISH_MESSAGE = Formatter.Info("구간이 등록되었습니다.");
    private static final String DELETE_FINISH_MESSAGE = Formatter.Info("구간이 삭제되었습니다.");

    public static void printStationNameInputMessage() {
        System.out.println(STATION_NAME_INPUT_MESSAGE);
    }

    public static void printPositionInputMessage() {
        System.out.println(POSITION_INPUT_MESSAGE);
    }

    public static void printLineInputMessage() {
        System.out.println(LINE_INPUT_MESSAGE);
    }

    public static void printRegisterFinishMessage() {
        System.out.println(REGISTER_FINISH_MESSAGE);
    }

    public static void printDeleteFinishMessage() {
        System.out.println(DELETE_FINISH_MESSAGE);
    }

    public static void printDeleteLineInputMessage() {
        System.out.println(DELETE_LINE_INPUT_MESSAGE);
    }

    public static void printDeleteStationInputMessage() {
        System.out.println(DELETE_STATION_INPUT_MESSAGE);
    }
}
