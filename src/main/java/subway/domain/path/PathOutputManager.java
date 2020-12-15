package subway.domain.path;

import subway.common.GuideMessage;
import subway.common.InfoMessage;

public class PathOutputManager {
    private static final String LINE_TO_ADD_PATH_GUIDE = "노선을 입력하세요.";
    private static final String STATION_TO_ADD_PATH_GUIDE = "역이름을 입력하세요.";
    private static final String INDEX_TO_ADD_PATH_GUIDE = "순서를 입력하세요.";
    private static final String LINE_TO_DELETE_PATH_GUIDE = "삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_TO_DELETE_PATH_GUIDE = "삭제할 구간의 역을 입력하세요.";
    private static final String PATH_ADDED = "구간이 등록되었습니다.";
    private static final String PATH_DELETED = "구간이 삭제되었습니다.";

    private PathOutputManager() {
    }

    public static void printLineToAddPathGuide() {
        GuideMessage.print(LINE_TO_ADD_PATH_GUIDE);
    }

    public static void printStationToAddPathGuide() {
        GuideMessage.print(STATION_TO_ADD_PATH_GUIDE);
    }

    public static void printIndexToAddGuide() {
        GuideMessage.print(INDEX_TO_ADD_PATH_GUIDE);
    }

    public static void printLineToDeleteGuide() {
        GuideMessage.print(LINE_TO_DELETE_PATH_GUIDE);
    }

    public static void printStationToDeleteGuide() {
        GuideMessage.print(STATION_TO_DELETE_PATH_GUIDE);
    }

    public static void printAddedInfo() {
        System.out.println();
        InfoMessage.print(PATH_ADDED);
    }

    public static void printDeletedInfo() {
        System.out.println();
        InfoMessage.print(PATH_DELETED);
    }

}
