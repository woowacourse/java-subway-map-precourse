package subway.view.executeViews.lineManage;

import subway.line.LineController;
import subway.line.LineRequestDTO;
import subway.view.OutputView;
import subway.view.ViewStrategy;

import java.util.Scanner;

public class CreateLineView implements ViewStrategy {
    private static final String VIEW_NAME = "노선 등록";
    private static final String CREATE_LINE_MESSAGE = "등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String CREATE_COMPLETE = "지하철 노선이 등록되었습니다.";
    private final LineController lineController;
    private final Scanner scanner;

    public CreateLineView(LineController lineController, Scanner scanner) {
        this.lineController = lineController;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            OutputView.selectView(CREATE_LINE_MESSAGE);
            String lineName = scanner.nextLine();

            OutputView.selectView(START_STATION_MESSAGE);
            String startStation = scanner.nextLine();

            OutputView.selectView(END_STATION_MESSAGE);
            String endStation = scanner.nextLine();

            lineController.createLine(new LineRequestDTO(lineName, startStation, endStation));
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
