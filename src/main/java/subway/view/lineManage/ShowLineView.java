package subway.view.lineManage;

import subway.line.LineController;
import subway.view.OutputView;

import java.util.Scanner;

public class ShowLineView implements LineManageViewStrategy {
    private static final String VIEW_NAME = "노선 조회";
    private static final String SHOW_MESSAGE = "노선 목록";
    private final LineController lineController;

    public ShowLineView(LineController lineController) {
        this.lineController = lineController;
    }

    @Override
    public void show() {
        OutputView.selectView(SHOW_MESSAGE);
        lineController.findLines()
                .forEach(line -> OutputView.infoView(line.getName()));
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
