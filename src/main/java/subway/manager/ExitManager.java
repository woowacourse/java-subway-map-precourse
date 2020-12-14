package subway.manager;

import subway.view.OutputView;

import java.util.Scanner;

public class ExitManager implements Manager{
    private static final int EXIT = 0;

    @Override
    public void execute(Scanner scanner) {
        OutputView.printExit();
        System.exit(EXIT);
    }
}
