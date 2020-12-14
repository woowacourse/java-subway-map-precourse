package subway.userinterface.linemenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class LineDeleteInputController extends InputController {

    public LineDeleteInputController() {
        this.INPUT_INTRO = "\n## 삭제할 노선 이름을 입력하세요.";
    }

    @Override
    protected void validateInput() {
        InputValidator.validateLineExistence(userInput);
    }
}
