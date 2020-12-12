package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class OutputView {
    private static final String INFO_PREFIX = "[INFO] ";
    public static void printMainFunctions() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printStationFunctions() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    public static void printLineFunctions() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    public static void printSectionFunctions() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    public static void printSubwayMap(List<Line> lines) {
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            System.out.println(INFO_PREFIX + line.getName());
            System.out.println(INFO_PREFIX + "---");
            printStationsInLine(line);
            printEmptyLine();
        }
        printEmptyLine();
    }

    private static void printStationsInLine(Line line) {
        for (Station station : line.getStations()) {
            System.out.println(INFO_PREFIX + station.getName());
        }
    }

    public static void printSuccessToCreateStation() {
        System.out.println(INFO_PREFIX + "지하철 역이 등록되었습니다.");
        printEmptyLine();
    }

    public static void printSuccessToDeleteStation() {
        System.out.println(INFO_PREFIX + "지하철 역이 삭제되었습니다.");
        printEmptyLine();
    }

    public static void printSuccessToCreateLine() {
        System.out.println(INFO_PREFIX + "지하철 노선이 등록되었습니다.");
        printEmptyLine();
    }

    public static void printSuccessToCreateSection() {
        System.out.println(INFO_PREFIX + "구간이 등록되었습니다.");
        printEmptyLine();
    }

    public static void printSuccessToDeleteSection() {
        System.out.println(INFO_PREFIX + "구간이 삭제되었습니다.");
        printEmptyLine();
    }

    public static void printSuccessToDeleteLine() {
        System.out.println(INFO_PREFIX + "지하철 노선이 삭제되었습니다.");
        printEmptyLine();
    }

    public static void printStations(List<Station> stations) {
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        printEmptyLine();
    }

    public static void printLine(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println(INFO_PREFIX + line.getName());
        }
        printEmptyLine();
    }
}
