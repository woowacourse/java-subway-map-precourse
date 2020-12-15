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
        System.out.println("등록할 노선 이름을 입력하세요.");
        String registerLineName = InputView.inputName();
        List<Station> registerUpDownStations = new ArrayList<>();
        System.out.println("등록할 노선의 상행 종점역 이름을 입력하세요.");
        registerUpStation(registerUpDownStations);
        System.out.println("등록할 노선의 하행 종점역 이름을 입력하세요.");
        registerDownStation(registerUpDownStations);
        LineRepository.addLine(new Line(registerLineName, registerUpDownStations));
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    private static void registerUpStation(List<Station> registerUpDownStations) {
        String upStationName = InputView.inputName();
        for (int i = 0; i < StationRepository.getStations().size(); i++) {
            if (StationRepository.getStations().get(i).getName().equals(upStationName)) {
                registerUpDownStations.add(StationRepository.getStations().get(i));
            }
        }
        if (registerUpDownStations.size() == IS_NOT_REGISTERED_STATION_NUM) {
            registerUpDownStations.add(new Station(upStationName));
        }
    }

    private static void registerDownStation(List<Station> registerUpDownStations) {
        String downStationName = InputView.inputName();
        for (int i = 0; i < StationRepository.getStations().size(); i++) {
            if (StationRepository.getStations().get(i).getName().equals(downStationName)) {
                registerUpDownStations.add(StationRepository.getStations().get(i));
            }
        }
        if (registerUpDownStations.size() == ONE_REGISTERED_STATION_NUM) {
            registerUpDownStations.add(new Station(downStationName));
        }
    }

    private static void deleteLine() {
        System.out.println("삭제할 노선 이름을 입력하세요. ");
        String deleteLineName = InputView.inputName();
        LineRepository.deleteLineByName(deleteLineName);
        System.out.println("[INFO] 노선이 삭제 되었습니다.");
    }
}
