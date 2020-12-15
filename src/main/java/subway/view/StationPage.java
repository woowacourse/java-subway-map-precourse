package subway.view;

import subway.domain.Station;
import utils.ErrorUtils;
import utils.InfoUtils;

import java.util.List;

public class StationPage {
    public void printStationManagementPage(){
        System.out.println("\n## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printAddStationPage(){
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
    }

    public void printDeleteStationPage(){
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public void printSelectStationsPage(List<Station> stations){
        System.out.println("\n## 역 목록");
        stations.forEach(station -> InfoUtils.printInfo(station.getName()));
    }

    public void printCompleteAdd(){
        InfoUtils.printInfo("역이 등록되었습니다.");
    }

    public void printCompleteDelete(){
        InfoUtils.printInfo("역이 삭제되었습니다.");
    }

    public void printFailToDeleteError() {
        ErrorUtils.printError("삭제를 실패했습니다.");
    }

    public void printWrongItemError(){
        ErrorUtils.printError("잘못된 입력입니다.");
    }

    public void printShortNameError(){
        ErrorUtils.printError("역 이름은 두 글자 이상이어야 합니다.");
    }

    public void printDuplicateError(){
        ErrorUtils.printError("이미 존재하는 역입니다.");
    }

    public void printNullStationError(){
        ErrorUtils.printError("존재하지 않는 역입니다.");
    }
}
