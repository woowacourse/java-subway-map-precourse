package subway.domain.line;

import subway.common.GuideMessage;
import subway.common.InfoMessage;

public class LineOutputManager {
    private static final String LINE_ADD_GUIDE = "등록할 노선 이름을 입력하세요.";
    private static final String LINE_DELETE_GUIDE = "삭제할 노선 이름을 입력하세요.";
    private static final String UP_STATION_GUIDE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWN_STATION_GUIDE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String LINE_ADDED = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETED = "지하철 노선이 삭제되었습니다.";
    private static final String LINE_LIST = "노선 목록";

    private LineOutputManager() {
    }

    public static void printAddGuide() {
        GuideMessage.print(LINE_ADD_GUIDE);
    }

    public static void printDeleteGuide() {
        GuideMessage.print(LINE_DELETE_GUIDE);
    }

    public static void printUpStationGuide() {
        GuideMessage.print(UP_STATION_GUIDE);
    }

    public static void printDownStationGuide() {
        GuideMessage.print(DOWN_STATION_GUIDE);
    }

    public static void printAddedInfo() {
        System.out.println();
        InfoMessage.print(LINE_ADDED);
    }

    public static void printDeletedInfo() {
        System.out.println();
        InfoMessage.print(LINE_DELETED);
    }

    public static void printLines() {
        GuideMessage.print(LINE_LIST);
        for (Line line : LineRepository.lines()) {
            InfoMessage.print(line.getName());
        }
    }

}
