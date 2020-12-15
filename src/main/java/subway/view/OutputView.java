package subway.view;

import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        printLineBreak();
    }

    public static void printStationMenu() {
        printLineBreak();
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        printLineBreak();
    }

    public static void printLineMenu() {
        printLineBreak();
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        printLineBreak();
    }

    public static void printSectionMenu() {
        printLineBreak();
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        printLineBreak();
    }

    public static void printQuit() {
        printLineBreak();
        System.out.println("프로그램을 종료합니다. 감사합니다.");
    }

    public static void printStationRegisterSuccess() {
        printLineBreak();
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public static void printStationDeleteSuccess() {
        printLineBreak();
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public static void printStationList(List<Station> stations) {
        printLineBreak();
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

    public static void printLineRegisterSuccess() {
        printLineBreak();
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void printLineDeleteSuccess() {
        printLineBreak();
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void printLineList(List<Line> lines) {
        printLineBreak();
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
    }

    public static void printSectionRegisterSuccess() {
        printLineBreak();
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public static void printSectionDeleteSuccess() {
        printLineBreak();
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static void printExceptionMessage(String message) {
        printLineBreak();
        System.out.println(message);
    }

    public static void printLineBreak() {
        System.out.println();
    }
}
