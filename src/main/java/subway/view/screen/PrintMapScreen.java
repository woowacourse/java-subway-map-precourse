package subway.view.screen;

import subway.domain.LineRepository;
import subway.view.OutputView;

import java.util.Scanner;

public class PrintMapScreen implements Screen {
    private static final String TITLE = "지하철 노선도";
    public static final String ENTER = "\n";

    @Override
    public void show() {
        OutputView.printNewLine();
        OutputView.printWithDoubleSharp(TITLE);
    }

    @Override
    public void run(Scanner scanner) {
        LineRepository.printLineInfo();
        ScreenStack.returnToFirstScreen();
    }
}
