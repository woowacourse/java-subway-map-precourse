package subway.userinterface.stationmenu;

import subway.userinterface.InputController;
import subway.util.InputValidator;

public class StationRegisterInputController extends InputController {

    public StationRegisterInputController() {
        this.INPUT_INTRO = "\n## 등록할 역 이름을 입력하세요.";
    }

    @Override
    protected void validateInput() throws IllegalArgumentException {
        InputValidator.validateInputLength(userInput);
        InputValidator.validateStationDuplication(userInput);
    }
}
