package subway;

import subway.enums.MainInput;
import subway.enums.StationInput;
import subway.view.InputView;

import java.util.Scanner;

public class Controller {

    private final Scanner SCANNER;
    public Controller(Scanner scanner) {
        this.SCANNER = scanner;
    }


    public void run() {
        InputView inputView = new InputView(SCANNER);
        String mainViewInput = "";

        do {
            mainViewInput = inputView.mainView();
            MainInput.getInstance(mainViewInput).moveView(SCANNER);
        } while (!MainInput.isQuit(mainViewInput));

    }

}
