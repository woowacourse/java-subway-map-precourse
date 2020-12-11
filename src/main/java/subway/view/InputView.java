package subway.view;

import java.util.Scanner;
import subway.exception.ExitSystemException;

public class InputView {
    // todo 입력 데이터를 적절한 컨트롤러에게 전달

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    private void printSubwayMap() {

    }

    private void exitSystem() {
        throw new ExitSystemException();
    }

    private String getInput() {
        return scanner.next();
    }
}
