package subway.view;

public class OutputView {
    private static final String INFO_PREFIX = "[INFO] ";
    public static void printMainFunctions() {
        System.out.println("## 메인화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    public static void printFunctions(String mainFunctionNumber) {
        if (mainFunctionNumber.equals("1")) {
            printStationFunctions();
            return;
        }
        if (mainFunctionNumber.equals("2")) {
            printLineFunctions();
            return;
        }
        if (mainFunctionNumber.equals("3")) {
            printSectionFunctions();
            return;
        }
        if (mainFunctionNumber.equals("4")) {
            printSubwayMap();
            return;
        }
    }

    private static void printStationFunctions() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    private static void printLineFunctions() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        printEmptyLine();
    }

    private static void printSectionFunctions() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    private static void printSubwayMap() {
        System.out.println("## 지하철 노선도");
    }

    public static void printSuccessToCreateStation() {
        System.out.println(INFO_PREFIX + "지하철 역이 등록되었습니다.");
        printEmptyLine();
    }
}
