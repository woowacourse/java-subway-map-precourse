package subway;

import subway.enums.MainInput;
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
            moveViewTo(mainViewInput, inputView);
        } while (!MainInput.isQuit(mainViewInput));
    }

    private void moveViewTo(String inputValue, InputView inputView) {
        if (inputValue.equals(MainInput.stationView.getInputValue())) {
            do {
                inputView.stationView();
            } while();
        }
    }


}
