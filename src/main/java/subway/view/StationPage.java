package subway.view;

import subway.domain.Station;
import utils.InfoUtils;

import java.util.List;

public class StationPage {
    public static void printStationManagementPage(){
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void printAddStationPage(){
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
    }

    public static void printDeleteStationPage(){
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public static void printSelectStationsPage(List<Station> stations){
        System.out.println("\n## 역 목록");
        stations.forEach(station -> InfoUtils.printInfo(station.getName()));
    }
}
