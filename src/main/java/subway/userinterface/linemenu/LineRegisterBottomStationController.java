package subway.userinterface.linemenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class LineRegisterBottomStationController extends InputController {

    public LineRegisterBottomStationController() {
        this.INPUT_INTRO = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateStationExistence(userInput);
    }
}
