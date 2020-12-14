package subway.userinterface;

import subway.util.InputValidator;

public class ViewInputController extends InputController {

    public ViewInputController() {
        this.INPUT_INTRO = "\n## 원하는 기능을 선택하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException{
        InputValidator.validateSubMenuInput(userInput);
    }
}
