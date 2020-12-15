package subway.userinterface.intervalmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class IntervalLineInputController extends InputController {

    public IntervalLineInputController() {
        this.INPUT_INTRO = "\n## 노선을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateLineExistence(userInput);
    }
}
