package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String INFORMATION = "[INFO] ";
    private static final String LINE = "---";

    public static void printMainScene() {
        System.out.println(NEW_LINE + "## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static void printStationManagementScene() {
        System.out.println(NEW_LINE + "## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public static void printChoiceFunction() {
        System.out.println(NEW_LINE + "## 원하는 기능을 선택하세요.");
    }

    public static void printInputRegisterStation() {
        System.out.println(NEW_LINE + "## 등록할 역 이름을 입력하세요.");
    }

    public static void printRegisteredStationMessage() {
        System.out.println(NEW_LINE + "[INFO] 지하철 역이 등록되었습니다.");
    }

    public static void printInputRemoveStation() {
        System.out.println(NEW_LINE + "## 삭제할 역 이름을 입력하세요.");
    }

    public static void printRemovedStationMessage() {
        System.out.println(NEW_LINE + "[INFO] 지하철 역이 삭제되었습니다.");
    }
    
    public static void printStationList(List<Station> stations) {
        System.out.println(NEW_LINE + "## 역 목록");

        stations.forEach(station -> System.out.println(INFORMATION + station.getName()));
    }

    public static void printLineScene() {
        System.out.println(NEW_LINE + "## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public static void printInputRegisterLine() {
        System.out.println(NEW_LINE + "## 등록할 노선 이름을 입력하세요.");
    }

    public static void printInputRegisterLineUpStation() {
        System.out.println(NEW_LINE + "## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void printInputRegisterLineDownStation() {
        System.out.println(NEW_LINE + "## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void printRegisteredLineMessage() {
        System.out.println(NEW_LINE + "[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void printInputRemoveLine() {
        System.out.println(NEW_LINE + "## 삭제할 노선 이름을 입력하세요.");
    }

    public static void printRemovedLineMessage() {
        System.out.println(NEW_LINE + "[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void printLineList(List<Line> lines) {
        System.out.println(NEW_LINE + "## 노선 목록");

        lines.forEach(line -> System.out.println(INFORMATION + line.getName()));
    }

    public static void printSectionScene() {
        System.out.println(NEW_LINE + "## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public static void printInputLine() {
        System.out.println(NEW_LINE + "## 노선을 입력하세요.");
    }

    public static void printInputStation() {
        System.out.println(NEW_LINE + "## 역이름을 입력하세요.");
    }

    public static void printInputOrder() {
        System.out.println(NEW_LINE + "## 순서를 입력하세요.");
    }

    public static void printRegisteredSectionMessage() {
        System.out.println(NEW_LINE + "[INFO] 구간이 등록되었습니다.");
    }

    public static void printInputRemoveSectionLine() {
        System.out.println(NEW_LINE + "## 삭제할 구간의 노선을 입력하세요.");
    }

    public static void printInputRemoveSectionStation() {
        System.out.println(NEW_LINE + "## 삭제할 구간의 역을 입력하세요.");
    }

    public static void printRemovedSectionMessage() {
        System.out.println(NEW_LINE + "[INFO] 구간이 삭제되었습니다.");
    }

    public static void printSubwayMapMessage() {
        System.out.println(NEW_LINE + "## 지하철 노선도");
    }

    public static void printSubwayMap(Line line) {
        System.out.println(INFORMATION + line.getName());
        System.out.println(LINE);

        line.getSectionStations().getStations().forEach(station -> System.out.println(INFORMATION + station.getName()));
        System.out.println();
    }
}
