package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.option.StationOption;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class StationService extends BaseService {
    private static final String HEADER = "## 역 관리 화면";
    private static final String REGISTER_STATION_QUESTION = "## 등록할 역 이름을 입력하세요.";
    private static final String REGISTER_STATION_SUCCESS = "지하철 역이 등록되었습니다.";
    private static final String DELETE_STATION_QUESTION = "## 삭제할 역 이름을 입력하세요.";
    private static final String ERR_LINE_PASSED_STATION = "역을 지나는 노선이 있습니다.";
    private static final String ERR_UNREGISTERED_STATION = "등록되지 않은 역입니다.";
    private static final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(StationOption.values()), HEADER);
    }

    public static void register() {
        OutputView.println(REGISTER_STATION_QUESTION);
        StationRepository.addStation(new Station(InputView.getStationName()));
        OutputView.printInfo(REGISTER_STATION_SUCCESS);
    }

    public static void delete() {
        OutputView.println(DELETE_STATION_QUESTION);
        Station station = StationRepository.getStation(InputView.getStationName());
        if (station.isLinePassed()){
            throw new IllegalArgumentException(ERR_LINE_PASSED_STATION);
        }
        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_STATION);
        }
        OutputView.printInfo(DELETE_STATION_SUCCESS);
    }

    public static void printStationList() {
        OutputView.printStationList(StationRepository.stations());
    }
}
