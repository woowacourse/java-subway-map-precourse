package subway.view;

public class OutputView {

    public static void printMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static void printStationManagementMenu() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public static void printLineStationManagementMenu() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public static void printSectionManagementMenu() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public static void printAddStationSuccessMessage() {
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }

    public static void printDeleteStationSuccessMessage() {
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }

    public static void printAddLineStationSuccessMessage() {
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void printDeleteLineStationSuccessMessage() {
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void printAddSectionSuccessMessage() {
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    public static void printDeleteSectionSuccessMessage() {
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
    }
}