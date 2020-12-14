package subway.view.outputview;

import subway.domain.Station;

import java.util.List;

import static subway.view.outputview.OutputView.*;

public class StationOutputView {
    private static String STATION_VIEW = "역 관리 화면\n";
    private static String STATION_LIST = "역 목록";
    private static String STATION_MENU = "1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    private static String DELETE_STATION = "삭제할 역 이름을 입력하세요.\n";
    private static String REGISTER_STATION = "등록할 역 이름을 입력하세요.\n";
    private static String SUCCESS_ADD_STATION = "지하철 역이 등록되었습니다.\n";
    private static String SUCCESS_DELETE_STATION = "지하철 역이 삭제되었습니다.\n";

    public static void showMenu() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(STATION_VIEW);
        stringBuilder.append(STATION_MENU);
        selectMenu();
    }

    public static void showAllStations(List<Station> stations) {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(STATION_LIST);
        stations.forEach(station ->
                stringBuilder.append(INFO_SYMBOL+station.getName()));
        stringBuilder.append("\n");
        print();
    }

    public static void registerStationName() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(REGISTER_STATION);
        print();
    }

    public static void successAdd() {
        stringBuilder.append(INFO_SYMBOL);
        stringBuilder.append(SUCCESS_ADD_STATION);
        print();
    }

    public static void deleteStationName() {
        stringBuilder.append(MENU_SYMBOL);
        stringBuilder.append(DELETE_STATION);
        print();
    }
}
