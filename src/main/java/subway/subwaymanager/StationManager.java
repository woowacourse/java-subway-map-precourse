package subway.subwaymanager;

import subway.domain.Station;
import subway.domain.StationRepository;
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
                registerStation();
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

    private static void registerStation() {
        System.out.println("등록할 역 이름을 입력하세요.");
        String registerStationName = InputView.inputName();
        StationRepository.addStation(new Station(registerStationName));
    }
}
