package view;

public class InputView {

    public static void mainView() {
        System.out.println("## 메인화면");
        System.out.println("1. 역관리\n" + "2. 노선관리\n" + "3.구간 관리\n" + "지하철 노선도 출력\n" + "Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void stationManageView() {
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록\n" + "2. 역 삭제\n" + "3.역 조회\n" + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void lineManageView() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록\n" + "2. 노선 삭제\n" + "3.노선 조회\n" + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void sectionManageView() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }
}
