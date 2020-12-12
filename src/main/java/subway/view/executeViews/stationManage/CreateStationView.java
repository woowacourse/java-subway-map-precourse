package subway.view.executeViews.stationManage;

import subway.station.StationController;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.Scanner;

public class CreateStationView implements ViewStrategy {
    private static final String VIEW_NAME = "역 등록";
    private static final String CREATE_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String CREATE_COMPLETE = "지하철 역이 등록되었습니다.";
    private final StationController stationController;
    private final Scanner scanner;

    public CreateStationView(StationController stationController, Scanner scanner) {
        this.stationController = stationController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            OutputView.selectView(CREATE_MESSAGE);
            String stationName = scanner.nextLine();
            OutputView.enter();
            stationController.createStation(stationName);
            OutputView.infoView(CREATE_COMPLETE);
        } catch (IllegalStateException e) {
            OutputView.errorView(e.getMessage());
        }
    }

    @Override
    public String viewName() {
        return VIEW_NAME;
    }
}
