package subway.userinterface.linemenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class LineRegisterInputController extends InputController {

    public LineRegisterInputController() {
        this.INPUT_INTRO = "\n## 등록할 노선 이름을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateInputLength(userInput);
        InputValidator.validateInputDuplication(userInput);
    }
}
