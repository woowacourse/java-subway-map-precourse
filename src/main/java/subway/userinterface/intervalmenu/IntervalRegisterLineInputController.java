package subway.userinterface.intervalmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class IntervalRegisterLineInputController extends InputController {

    public IntervalRegisterLineInputController() {
        this.INPUT_INTRO = "\n## 노선을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateLineExistence(userInput);
    }
}
