package subway.view.lineStationManage;

import subway.line.LineController;
import subway.view.BackView;
import subway.view.OutputView;
import subway.view.ViewStrategy;
import subway.view.stationManage.DeleteStationView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LineStationManageView implements ViewStrategy {
    private static final String VIEW_NAME = "구간 관리";
    private static final String LINE_STATION_MESSAGE = "구간 관리 화면";
    private static final Map<String, LineStationViewStrategy> LINE_STATION_VIEW = new LinkedHashMap<>();
    private final Scanner scanner;
    private LineStationViewStrategy lineStationViewStrategy;

    public LineStationManageView(Scanner scanner, LineController lineController) {
        this.scanner = scanner;
        LINE_STATION_VIEW.put("1", new AddStationOnLineView(lineController, scanner));
        LINE_STATION_VIEW.put("2", new RemoveStationFromLineView(lineController, scanner));
        LINE_STATION_VIEW.put("B", new BackView());
    }

    @Override
    public void show() {
        manageLineStation();
        OutputView.enter();
        lineStationViewStrategy.show();
        OutputView.enter();
    }

    private void manageLineStation() {
        OutputView.selectStrategy(LINE_STATION_VIEW, LINE_STATION_MESSAGE);
        String stationLineKey = scanner.nextLine();
        lineStationViewStrategy = LINE_STATION_VIEW.get(stationLineKey);
        if (lineStationViewStrategy == null) {
            OutputView.notExist();
            manageLineStation();
        }
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
