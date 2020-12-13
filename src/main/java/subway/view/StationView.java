package subway.view;

import subway.domain.Name;

import java.util.Scanner;
import java.util.List;

public class StationView {
    private static StationView stationView;
    private final Scanner scanner;

    private StationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static StationView getInstance(Scanner scanner) {
        if (stationView == null) {
            stationView = new StationView(scanner);
            return stationView;
        }
        return stationView;
    }

    public Name getStationNameToAdd() {
        OutputView.printMsg("## 등록할 역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void announceAdditionSuccess() {
        OutputView.printInfoMsg("지하철 역이 등록되었습니다.\n");
    }

    public Name getStationNameToDelete() {
        OutputView.printMsg("## 삭제할 역 이름을 입력하세요.\n");
        return InputView.getName(scanner);
    }

    public void announceDeletionSuccess() {
        OutputView.printInfoMsg("지하철 역이 삭제되었습니다.\n");
    }

    public void printStationList(List<String> names) {
        OutputView.printMsg("## 역 목록\n");
        names.stream().forEach(OutputView::printInfoMsg);
    }
}
