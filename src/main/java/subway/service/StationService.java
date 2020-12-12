package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationService {
    private static final String ERR_LINE_PASSED_STATION = "역을 지나는 노선이 있습니다.";
    private static final String ERR_UNREGISTERED_STATION = "등록되지 않은 역입니다.";

    public static void register() {
        OutputView.printRegisterStationQuestion();
        StationRepository.addStation(new Station(InputView.getStationName()));
        OutputView.printRegisterStationSuccess();
    }

    public static void delete() {
        OutputView.printDeleteStationQuestion();
        Station station = StationRepository.getStation(InputView.getStationName());
        if (station.isLinePassed()){
            throw new IllegalArgumentException(ERR_LINE_PASSED_STATION);
        }
        if (!StationRepository.deleteStation(station)) {
            throw new IllegalArgumentException(ERR_UNREGISTERED_STATION);
        }
        OutputView.printDeleteStationSuccess();
    }

    public static void printStationList() {
        OutputView.printStationList(StationRepository.stations());
    }
}
