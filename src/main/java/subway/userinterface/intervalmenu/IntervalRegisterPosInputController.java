package subway.userinterface.intervalmenu;

import subway.userinterface.InputController;
import subway.userinterface.linemenu.LineRegisterController;
import subway.util.InputValidator;

public class IntervalRegisterPosInputController extends InputController {

    public IntervalRegisterPosInputController() {
        this.INPUT_INTRO = "\n## 순서를 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateIntervalPosition(userInput, IntervalRegisterController.getCurrentLine());
    }
}
