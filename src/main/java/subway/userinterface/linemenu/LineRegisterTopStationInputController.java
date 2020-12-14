package subway.userinterface.linemenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class LineRegisterTopStationInputController extends InputController {

    public LineRegisterTopStationInputController() {
        this.INPUT_INTRO = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateStationExistence(userInput);
    }
}
