package subway.userinterface;

public class MenuInterface {
    public static void printMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요");
    }

    public static void printStationMenu() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요");
    }

    public static void printLineMenu() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요");
    }

    public static void printIntervalMenu() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요");
    }

    public static void printAddStation() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
    }

    public static void printDeleteStation() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public static void printAddLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
    }

    public static void printAddLine_StartStation() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void printAddLine_EndStation() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public static void printDeleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
    }

    public static void printAddInterval_Line() {
        System.out.println("\n## 노선을 입력하세요.");
    }

    public static void printAddInterval_Station() {
        System.out.println("\n## 역 이름을 입력하세요.");
    }

    public static void printAddInterval_Sequence() {
        System.out.println("\n## 순서를 입력하세요");
    }

    public static void printDeleteInterval_Line() {
        System.out.println("\n## 삭제할 구간의 노선 이름을 입력하세요.");
    }

    public static void printDeleteInterval_Station() {
        System.out.println("\n## 삭제할 구간의 역 이름을 입력하세요.");
    }

}
