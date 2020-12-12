package subway.view;

public class OutputView {
    public static void printMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
    }

    public static void printStationMenu() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
    }

    public static void printLineMenu() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
    }

    public static void printSectionMenu() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기\n");
    }
    
    public static void printStationRegisterSuccess() {
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }
    
    public static void printStationDeleteSuccess() {
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }
}
