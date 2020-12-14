package subway.view.executeViews.stationManage;

import subway.station.StationController;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.Scanner;

public class DeleteStationView implements ViewStrategy {
    private static final String VIEW_NAME = "역 삭제";
    private static final String DELETE_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String DELETE_SUCCESS = "지하철 역이 삭제되었습니다.";
    private final StationController stationController;
    private final Scanner scanner;

    public DeleteStationView(StationController stationController, Scanner scanner) {
        this.stationController = stationController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            OutputView.selectView(DELETE_MESSAGE);
            String stationName = scanner.nextLine();
            OutputView.enter();
            stationController.deleteStation(stationName);
            OutputView.infoView(DELETE_SUCCESS);
        } catch (IllegalStateException e) {
            OutputView.errorView(e.getMessage());
        }

    }

    @Override
    public String viewName() {
        return VIEW_NAME;
    }
}
