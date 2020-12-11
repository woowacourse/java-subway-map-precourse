package subway.view.lineStationManage;

import subway.line.LineController;
import subway.view.OutputView;

import java.util.Scanner;

public class AddStationOnLineView implements LineStationViewStrategy {
    private static final String VIEW_NAME = "구간 등록";
    private static final String GET_LINE_MESSAGE = "노선을 입력하세요.";
    private static final String GET_STATION_MESSAGE = "역이름을 입력하세요.";
    private static final String GET_INDEX_MESSAGE = "순서를 입력하세요.";
    private static final String ADD_STATION_COMPLETE = "구간이 등록되었습니다.";
    private static final String WRONG_NUMBER = "순서는 숫자를 입력해주세요.";
    private final LineController lineController;
    private final Scanner scanner;

    public AddStationOnLineView(LineController lineController, Scanner scanner) {
        this.lineController = lineController;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        try {
            OutputView.selectView(GET_LINE_MESSAGE);
            String lineName = scanner.nextLine();
            OutputView.enter();

            OutputView.selectView(GET_STATION_MESSAGE);
            String stationName = scanner.nextLine();
            OutputView.enter();

            OutputView.selectView(GET_INDEX_MESSAGE);
            int index = Integer.parseInt(scanner.nextLine());
            OutputView.enter();

            lineController.addStationOnLine(stationName, lineName, index);
            OutputView.infoView(ADD_STATION_COMPLETE);
        } catch (NumberFormatException e) {
            OutputView.errorView(WRONG_NUMBER);
        } catch (IllegalStateException e) {
            OutputView.errorView(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
