package subway;

import subway.enums.MainViewInput;
import subway.view.InputView;

import java.util.Scanner;

public class Controller {

    private final Scanner SCANNER;
    private String mainViewInput = "";

    public Controller(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public void run() {
        InputView inputView = new InputView(SCANNER);

        while (!MainViewInput.isQuit(mainViewInput)) {
            moveViewTo(inputView.mainView());
        };
    }

    private void moveViewTo(String inputValue) {

    }


}
