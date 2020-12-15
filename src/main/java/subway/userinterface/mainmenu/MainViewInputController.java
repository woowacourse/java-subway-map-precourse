package subway.userinterface.mainmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class MainViewInputController extends InputController {

    public MainViewInputController() {
        this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요.";
    }

    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateMainMenuInput(userInput);
    }
}
