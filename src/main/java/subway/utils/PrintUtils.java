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

    public void invalidMenuError(){
        System.out.println("[ERROR] 목록에 있는 메뉴 번호를 입력해주세요.");
    }

    public void invalidStationNameLengthError(){
        System.out.println("[ERROR] 역의 이름은 2글자 이상 입력해주세요.");
    }

    public void duplicateStationError(){
        System.out.println("[ERROR] 이미 존재하는 역입니다.");
    }

    public void nonExistentStationError(){
        System.out.println("[ERROR] 존재하지 않는 역입니다.");
    }
}
