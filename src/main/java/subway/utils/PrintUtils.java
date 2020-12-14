package subway.utils;

/**
 * 프로그램의 출력 부분을 담당하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class PrintUtils {

    public void printMainMenu(){
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
    }

    public void printSelectFunction(){
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printStationManagementMenu(){
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
    }

    public void printLineManagementMenu(){
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
    }

    public void printRouteManagementMenu(){
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기\n");
    }

    public void printAddStationGuide(){
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
    }

    public void printCompleteAddStation(){
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.\n");
    }

    public void printStationsList(){
        System.out.println("\n## 역 목록");
    }

    public void printStation(String stationName){
        System.out.println("[INFO] "+stationName);
    }

    public void printDeleteStationGuide(){
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public void printCompleteDeleteStation(){
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.\n");
    }

    public void printAddNewLineNameGuide(){
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
    }

    public void printUpboundTerminalNameGuide(){
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public void printDownboundTerminalNameGuide(){
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public void printLinesList(){
        System.out.println("\n## 역 목록");
    }

    public void printCompleteAddLine(){
        System.out.println("\n[INFO] 지하철 노선이 등록되었습니다.\n");
    }

    public void printDeleteLineGuide(){
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
    }

    public void printCompleteDeleteLine(){
        System.out.println("\n[INFO] 지하철 노선이 삭제되었습니다.\n");
    }

    public void printLineNameInputGuide(){
        System.out.println("\n## 노선을 입력하세요.");
    }

    public void printStationNameInputGuide(){
        System.out.println("\n## 역이름을 입력하세요.");
    }

    public void printOrderInputGuide(){
        System.out.println("\n## 순서를 입력하세요.");
    }

    public void printCompleteRouteRegistration(){ System.out.println("\n[INFO] 구간이 등록되었습니다.\n"); }

    public void printLineName(String lineName){ System.out.println("[INFO] "+lineName); }

    public void printHyphenLine(){System.out.println("[INFO] ---");}

    public void printStationName(String stationName){ System.out.println("[INFO] "+stationName); }

    public void printLineOfRouteDeletedGuide(){ System.out.println("\n## 삭제할 구간의 노선을 입력하세요."); }

    public void printStationOfRouteDeletedGuide(){ System.out.println("\n## 삭제할 구간의 역을 입력하세요."); }

    public void printCompleteRouteDeletion(){ System.out.println("\n[INFO] 구간이 삭제되었습니다.\n"); }

    public void invalidMenuError(){
        System.out.println("[ERROR] 목록에 있는 메뉴 번호를 입력해주세요.");
    }

    public void invalidStationNameLengthError(){
        System.out.println("[ERROR] 역의 이름은 2글자 이상 입력해주세요.");
    }

    public void invalidLineNameError(){
        System.out.println("[ERROR] 노선의 이름은 2글자 이상, '선'으로 끝나게 입력해주세요.");
    }

    public void duplicateStationError(){
        System.out.println("\n[ERROR] 이미 존재하는 역입니다.");
    }

    public void nonExistentStationError(){
        System.out.println("\n[ERROR] 존재하지 않는 역입니다.");
    }

    public void duplicateLineError(){
        System.out.println("\n[ERROR] 이미 존재하는 노선입니다.");
    }

    public void nonExistentLineError(){
        System.out.println("\n[ERROR] 존재하지 않는 노선입니다.");
    }

    public void sameTerminalNameError(){
        System.out.println("\n[ERROR] 상행 종점역과 하행 종점역은 달라야 합니다.");
    }

    public void stationOrderError(int stationNumber){
        System.out.println("\n[ERROR] 순서는 "+stationNumber+"이하의 양의 정수를 입력해주세요.");
    }

    public void impossibleRouteDeletion(){ System.out.println("\n[ERROR] 노선에 포함된 역이 두개 이하일 때는 제거할 수 없습니다.\n"); }
}
