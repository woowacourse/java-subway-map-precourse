package subway;

import subway.enums.MainInput;
import subway.view.MainInputView;

import java.util.Scanner;

public class Controller {

    private final Scanner SCANNER;
    public Controller(Scanner scanner) {
        this.SCANNER = scanner;
    }


    public void run() {
        MainInputView mainInputView = new MainInputView(SCANNER);
        String mainViewInput = "";

        do {
            mainViewInput = mainInputView.mainView();
            MainInput.getInstanceByInput(mainViewInput).moveView(SCANNER);
        } while (!MainInput.isQuit(mainViewInput));

    }

}
