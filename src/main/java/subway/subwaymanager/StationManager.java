package subway.subwaymanager;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateStationOrLineSelect;

import static subway.utils.Constant.*;

public class StationManager {

    public static void stationChoice() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printStationContents();
            String inputStationSelect = InputView.inputSelect();
            ValidateStationOrLineSelect.validateStationOrLineSelect(inputStationSelect);
            isContinue = selectStation(inputStationSelect);
        }
    }

    private static boolean selectStation(String inputStationSelect) {
        if (inputStationSelect.equals(CONTENTS_NUMBER_FIRST)) {
            registerStation();
        }
        if (inputStationSelect.equals(CONTENTS_NUMBER_SECOND)) {
            deleteStation();
        }
        if (inputStationSelect.equals(CONTENTS_NUMBER_THIRD)) {
            OutputView.printStations();
        }
        if (inputStationSelect.equals(CONTENTS_NUMBER_BACK)) {
            return false;
        }
        return true;
    }

    private static void registerStation() {
        System.out.println("등록할 역 이름을 입력하세요.");
        String registerStationName = InputView.inputName();
        StationRepository.addStation(new Station(registerStationName));
    }

    private static void deleteStation() {
        System.out.println("삭제할 역 이름을 입력하세요. ");
        String deleteStationName = InputView.inputName();
        StationRepository.deleteStation(deleteStationName);
    }
}
