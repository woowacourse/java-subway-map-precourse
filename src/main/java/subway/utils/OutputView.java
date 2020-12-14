package subway.utils;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.List;

public class OutputView {

    public static void printMainContents() {
        System.out.println("메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printStationContents() {
        System.out.println("역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");

        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printStations() {
        System.out.println("역 목록");
        List<Station> stations = StationRepository.getStations();
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }

    public static void printLineContents() {
        System.out.println("노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");

        System.out.println("원하는 기능을 선택하세요.");
    }

    public static void printLines() {
        System.out.println("노선 목록");
        List<Line> lines = LineRepository.getLines();
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
        System.out.println();
    }
}
