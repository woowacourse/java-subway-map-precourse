package subway.view;

import utils.ErrorUtils;
import utils.InfoUtils;

public class RouteMapPage {
    public void printRouteManagementPage() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printChooseLinePage() {
        System.out.println("\n## 노선을 입력하세요.");
    }

    public void printChooseStationPage() {
        System.out.println("\n## 역 이름을 입력하세요.");
    }

    public void printChooseIndexPage() {
        System.out.println("\n## 순서를 입력하세요.");
    }

    public void printCompleteAdd() {
        InfoUtils.printInfo("구간이 등록되었습니다.");
    }

    public void printChooseDeleteLinePage() {
        System.out.println("\n## 삭제할 노선을 입력하세요.");
    }

    public void printChooseDeleteStationPage() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
    }

    public void printCompleteDelete() {
        InfoUtils.printInfo("구간이 삭제되었습니다.");
    }

    public void printWrongItemError() {
        ErrorUtils.printError("잘못된 입력입니다.");
    }

    public void printNullLineError() {
        ErrorUtils.printError("존재하지 않는 노선입니다.");
    }

    public void printNullStationError() {
        ErrorUtils.printError("존재하지 않는 역입니다.");
    }

    public void printDuplicateStationInLineError() {
        ErrorUtils.printError("해당 역이 이미 노선에 존재합니다.");
    }

    public void printWrongIndexError() {
        ErrorUtils.printError("현재 노선에 등록된 역의 개수보다 큰 인덱스는 입력이 불가합니다.");
    }

    public void printDeleteError() {
        ErrorUtils.printError("현재 노선에 역이 두개 남아 삭제가 불가능합니다.");
    }
}
