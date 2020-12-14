package subway.view.executeViews.lineStationManage;

import subway.line.LineController;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.Scanner;

public class RemoveStationFromLineView implements ViewStrategy {
    private static final String VIEW_NAME = "구간 삭제";
    private static final String GET_LINE_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String GET_STATION_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String REMOVE_SUCCESS = "구간이 삭제되었습니다.";
    private final LineController lineController;
    private final Scanner scanner;

    public RemoveStationFromLineView(LineController lineController, Scanner scanner) {
        this.lineController = lineController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            OutputView.selectView(GET_LINE_MESSAGE);
            String lineName = scanner.nextLine();

            OutputView.selectView(GET_STATION_MESSAGE);
            String stationName = scanner.nextLine();

            lineController.removeStationFromLine(stationName, lineName);
            OutputView.infoView(REMOVE_SUCCESS);
        } catch (IllegalStateException e) {
            OutputView.errorView(e.getMessage());
        }
    }

    @Override
    public String viewName() {
        return VIEW_NAME;
    }
}
