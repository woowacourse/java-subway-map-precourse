package subway.view.screen;

import subway.view.OutputView;

import java.util.Scanner;

// 지하철 노선도 출력
public class PrintMapScreen implements Screen {
    private static final String TITLE = "지하철 노선도";
    public static final String ENTER = "\n";

    @Override
    public void show() {
        OutputView.printTitle(CHANGE_LINE + DOUBLE_SHARP + TITLE);
    }

    @Override
    public void run(Scanner scanner) {
        OutputView.printMapTitle("2호선");
        OutputView.printMapStation("교대역");
        OutputView.print(ENTER);
        ScreenStack.returnToFirstScreen();
    }
}
