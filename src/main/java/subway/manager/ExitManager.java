package subway.manager;

import subway.view.OutputView;

import java.util.Scanner;

public class ExitManager implements Manager{

    @Override
    public void execute(Scanner scanner) {
        OutputView.printExit();
    }
}
