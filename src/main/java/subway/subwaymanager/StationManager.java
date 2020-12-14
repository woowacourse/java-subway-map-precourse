package subway.subwaymanager;

import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateStationSelect;

import static subway.utils.Constant.*;

public class StationManager {

    public static void stationChoice() {
        while (true) {
            OutputView.printStationContents();

            String inputStationSelect = InputView.inputSelect();
            ValidateStationSelect.validateStationSelect(inputStationSelect);
            if (inputStationSelect.equals(CONTENTS_NUMBER_FIRST)) {
            }
            if (inputStationSelect.equals(CONTENTS_NUMBER_SECOND)) {
            }
            if (inputStationSelect.equals(CONTENTS_NUMBER_THIRD)) {
            }
            if (inputStationSelect.equals(CONTENTS_NUMBER_BACK)) {
                break;
            }
        }
    }
}
