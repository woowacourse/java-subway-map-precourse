package subway.subwaymanager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputView;
import subway.utils.OutputView;
import subway.validators.ValidateStationOrLineSelect;

import java.util.ArrayList;
import java.util.List;

import static subway.utils.Constant.*;

public class LineManager {

    public static void lineChoice() {
        boolean isContinue = true;
        while (isContinue) {
            OutputView.printLineContents();
            String inputLineSelect = InputView.inputSelect();
            ValidateStationOrLineSelect.validateStationOrLineSelect(inputLineSelect);
            isContinue = selectLine(inputLineSelect);
        }
    }

    private static boolean selectLine(String inputLineSelect) {
        if (inputLineSelect.equals(CONTENTS_NUMBER_FIRST)) {
            registerLine();
        }
        if (inputLineSelect.equals(CONTENTS_NUMBER_SECOND)) {
            deleteLine();
        }
        if (inputLineSelect.equals(CONTENTS_NUMBER_THIRD)) {
            OutputView.printLines();
        }
        if (inputLineSelect.equals(CONTENTS_NUMBER_BACK)) {
            return false;
        }
        return true;
    }

    private static void registerLine() {
        String registerLineName = InputView.inputRegisterLineName();
        List<Station> registerUpDownStations = new ArrayList<>();
        registerUpDownStation(registerUpDownStations, InputView.inputUpStationsName());
        registerUpDownStation(registerUpDownStations, InputView.inputDownStationsName());
        LineRepository.addLine(new Line(registerLineName, registerUpDownStations));
        OutputView.printRegisteredLine();
    }

    private static void registerUpDownStation(List<Station> registerUpDownStations, String stationName) {
        registerUpDownStations.add(getStation(stationName));
    }

    private static Station getStation(String stationName) {
        Station station = StationRepository.getStationByName(stationName);
        if (station != null) {
            return station;
        }
        return new Station(stationName);
    }

    private static void deleteLine() {
        String deleteLineName = InputView.inputDeleteLineName();
        LineRepository.deleteLineByName(deleteLineName);
        OutputView.printDeletedLine();
    }
}
