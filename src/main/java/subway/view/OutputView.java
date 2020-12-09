package subway.view;

public class OutputView {
    private static final String NEW_LINE = "\n";

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
}
