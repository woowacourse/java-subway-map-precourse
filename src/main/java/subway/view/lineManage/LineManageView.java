package subway.view.lineManage;

import subway.line.LineController;
import subway.line.LineRepositoryJava;
import subway.station.StationRepositoryJava;
import subway.view.OutputView;
import subway.view.ViewStrategy;
import subway.view.BackView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LineManageView implements ViewStrategy {
    private static final String VIEW_NAME = "노선 관리";
    private static final String LINE_MANAGE_MESSAGE = "노선 관리 화면";
    private static final Map<String, LineManageViewStrategy> LINE_MANAGE_VIEW = new LinkedHashMap<>();
    private final Scanner scanner;
    private LineManageViewStrategy lineManageViewStrategy;

    public LineManageView(Scanner scanner) {
        this.scanner = scanner;
        LineController lineController = LineController.get(LineRepositoryJava.get(), StationRepositoryJava.get());
        LINE_MANAGE_VIEW.put("B", new BackView());
    }

    @Override
    public void show() {
        manageLine();
        OutputView.enter();
        lineManageViewStrategy.show();
        OutputView.enter();
    }

    private void manageLine() {
        OutputView.selectStrategy(LINE_MANAGE_VIEW, LINE_MANAGE_MESSAGE);
        String lineManageKey = scanner.nextLine();
        lineManageViewStrategy = LINE_MANAGE_VIEW.get(lineManageKey);
        if(lineManageViewStrategy == null) {
            OutputView.notExist();
            manageLine();
        }
    }


    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
