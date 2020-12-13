package subway.domain.path;

import subway.common.Guide;

public class PathOutputManager {

    public static final String STATION_TO_ADD_PATH_GUIDE = "역이름을 입력하세요.";
    public static final String INDEX_TO_ADD_PATH_GUIDE = "순서를 입력하세요.";
    public static final String STATION_TO_DELETE_PATH_GUIDE = "삭제할 역이름을 입력하세요.";

    public static void printStationToAddPath() {
        Guide.print(STATION_TO_ADD_PATH_GUIDE);
    }
    public static void printIndexToAddPath() {
        Guide.print(INDEX_TO_ADD_PATH_GUIDE);
    }


}
