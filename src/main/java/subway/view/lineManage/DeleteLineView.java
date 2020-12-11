package subway.view.lineManage;

import subway.line.LineController;
import subway.view.OutputView;

import java.util.Scanner;

public class DeleteLineView implements LineManageViewStrategy {
    private static final String VIEW_NAME = "노선 삭제";
    private static final String DELETE_MESSAGE = "삭제할 노선 이름을 입력하세요";
    private static final String DELETE_SUCCESS = "지하철 노선이 삭제되었습니다.";
    private final LineController lineController;
    private final Scanner scanner;

    public DeleteLineView(LineController lineController, Scanner scanner) {
        this.lineController = lineController;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        try {
            OutputView.selectView(DELETE_MESSAGE);
            String lineName = scanner.nextLine();
            OutputView.enter();
            lineController.removeLine(lineName);
            OutputView.infoView(DELETE_SUCCESS);
        } catch (IllegalStateException e) {
            OutputView.errorView(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return VIEW_NAME;
    }
}
