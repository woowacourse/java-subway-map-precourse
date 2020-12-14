package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateMainSelect;

import static subway.utils.Constant.*;

public class MainSelectManager {
    public static void mainSelectManager() {
        while (true) {
            OutputView.printMainContents();
            String inputMainSelect = InputView.inputSelect();
            ValidateMainSelect.validateMainSelect(inputMainSelect);

            if (inputMainSelect.equals(CONTENTS_NUMBER_FIRST)) {
                StationManager.stationChoice();
            }
            if (inputMainSelect.equals(CONTENTS_NUMBER_SECOND)) {
            }
            if (inputMainSelect.equals(CONTENTS_NUMBER_THIRD)) {
            }
            if (inputMainSelect.equals(CONTENTS_NUMBER_FOURTH)) {
            }
            if (inputMainSelect.equals(CONTENTS_NUMBER_QUIT)) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
