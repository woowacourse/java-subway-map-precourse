package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateStationOrLineSelect;

import static subway.utils.Constant.*;
import static subway.utils.Constant.CONTENTS_NUMBER_BACK;

public class LineManager {
    public static void lineChoice() {
        while (true) {
            OutputView.printLineContents();

            String inputLineSelect = InputView.inputSelect();
            ValidateStationOrLineSelect.validateStationOrLineSelect(inputLineSelect);
            if (inputLineSelect.equals(CONTENTS_NUMBER_FIRST)) {
            }
            if (inputLineSelect.equals(CONTENTS_NUMBER_SECOND)) {
            }
            if (inputLineSelect.equals(CONTENTS_NUMBER_THIRD)) {
            }
            if (inputLineSelect.equals(CONTENTS_NUMBER_BACK)) {
                break;
            }
        }
    }
}
