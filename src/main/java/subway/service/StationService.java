package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.option.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class StationService extends BaseService {
    private static final String HEADER = "역 관리 화면";
    private static final String REGISTER_STATION_QUESTION = "등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_QUESTION = "삭제할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.";

    private static final String ERR_LINE_PASSED_STATION = "역을 지나는 노선이 있습니다.";
    private static final String ERR_UNREGISTERED_STATION = "등록되지 않은 역입니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(StationOption.values()), HEADER);
    }

    public static void register() {
        String stationName = getStationNameByQuestion(REGISTER_STATION_QUESTION);
        registerStation(stationName);
    }

    public static void delete() {
        Station station = getStationByQuestion(DELETE_STATION_QUESTION);
        checkStationLinePassing(station);
        deleteStation(station);
    }

    public static void printStationList() {
        OutputView.printStationList(StationRepository.stations());
    }

    private static void checkStationLinePassing(Station station) {
        if (station.isLinePassed()) {
            throw new IllegalArgumentException(ERR_LINE_PASSED_STATION);
        }
    }

    private static void registerStation(String stationName) {
        StationRepository.addStation(new Station(stationName));
        OutputView.printInfo(REGISTER_STATION_SUCCESS);
    }

    private static void deleteStation(Station station) {
        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_STATION);
        }
        OutputView.printInfo(DELETE_STATION_SUCCESS);
    }
}
