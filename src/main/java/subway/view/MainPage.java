package subway.view;


import subway.domain.Line;
import subway.domain.Station;
import utils.ErrorUtils;
import utils.InfoUtils;

import java.util.List;

public class MainPage {
    public void printMainPage() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printRouteMap(List<Line> lines) {
        System.out.println("\n## 지하철 노선도");
        for (Line line : lines) {
            InfoUtils.printInfo(line.getName());
            InfoUtils.printInfo("---");
            for (Station station : line.getStations()) {
                InfoUtils.printInfo(station.getName());
            }
            System.out.println();
        }
    }

    public void printWrongItemError() {
        ErrorUtils.printError("잘못된 입력입니다.");
    }
}