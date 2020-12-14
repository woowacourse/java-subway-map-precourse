package subway.view;

public class OutputView {
    public static void mainView(){
        System.out.println();
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
        functionSelectView();
    }

    public static void stationManageView(){
        System.out.println();
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
        functionSelectView();
    }

    public static void lineManageView(){
        System.out.println();
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
        functionSelectView();
    }

    public static void sectionManageView(){
        System.out.println();
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
        functionSelectView();
    }

    public static void functionSelectView(){
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
