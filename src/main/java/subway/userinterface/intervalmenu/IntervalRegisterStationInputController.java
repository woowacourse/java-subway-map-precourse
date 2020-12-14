package subway.userinterface.intervalmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class IntervalRegisterStationInputController extends InputController {

    public IntervalRegisterStationInputController() {
        this.INPUT_INTRO = "\n## 역이름을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateStationExistence(userInput);
    }
}
