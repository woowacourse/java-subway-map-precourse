package subway.view;

import subway.domain.Line;
import utils.ErrorUtils;
import utils.InfoUtils;

import java.util.List;

public class LinePage {
    public void printLineManagementPage() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printAddLinePage() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
    }

    public void printAddUpperTerminalPage() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public void printAddLowerTerminalPage() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public void printDeleteLinePage() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
    }

    public void printSelectLinesPage(List<Line> lines) {
        if (lines.size() != 0) {
            System.out.println("\n## 노선 목록");
            lines.forEach(line -> InfoUtils.printInfo(line.getName()));
            return;
        }
        ErrorUtils.printError("현재 노선이 없습니다.");
    }

    public void printCompleteAdd() {
        InfoUtils.printInfo("노선이 등록되었습니다.");
    }

    public void printCompleteDelete() {
        InfoUtils.printInfo("노선이 삭제되었습니다.");
    }

    public void printWrongItemError() {
        ErrorUtils.printError("잘못된 입력입니다.");
    }

    public void printFailToDeleteError() {
        ErrorUtils.printError("삭제를 실패했습니다.");
    }

    public void printShortNameError() {
        ErrorUtils.printError("노선 이름은 두 글자 이상이어야 합니다.");
    }

    public void printDuplicateError() {
        ErrorUtils.printError("이미 존재하는 노선입니다.");
    }

    public void printNullLineError() {
        ErrorUtils.printError("존재하지 않는 노선입니다.");
    }

    public void printNullStationError() {
        ErrorUtils.printError("해당 역이 존재하지 않습니다.");
    }
}

