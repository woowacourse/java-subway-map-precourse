package subway.userinterface.stationmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

import java.util.Scanner;

public class StationRegisterInputController extends InputController {

    public StationRegisterInputController() {
        this.INPUT_INTRO = "\n## 등록할 역 이름을 입력하세요.";
    }

    @Override
    protected void validateInput(Scanner scanner) throws IllegalArgumentException {
        InputValidator.validateInputLength(userInput);
        InputValidator.validateInputDuplication(userInput);
    }
}
