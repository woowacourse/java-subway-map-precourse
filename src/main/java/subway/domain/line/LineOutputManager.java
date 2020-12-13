package subway.domain.line;

import subway.common.Guide;

public class LineOutputManager {
    public static final String LINE_GUIDE = "등록할 노선 이름을 입력하세요.";
    public static final String UP_STATION_GUIDE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String DOWN_STATION_GUIDE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String LINE_TO_ADD_PATH_GUIDE = "노선을 입력하세요.";

    private LineOutputManager() {
    }


    public static void printLineGuide(String function) {
        Guide.print(function +LINE_GUIDE);
    }

    public static void printUpStationGuide() {
        Guide.print(UP_STATION_GUIDE);
    }


    public static void printDownStationGuide() {
        Guide.print(DOWN_STATION_GUIDE);
    }


    public static void printLineToAddPath() {
        Guide.print(LINE_TO_ADD_PATH_GUIDE);
    }
}
