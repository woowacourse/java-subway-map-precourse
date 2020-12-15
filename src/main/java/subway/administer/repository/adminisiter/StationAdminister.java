package subway.administer.repository.adminisiter;

import subway.domain.repository.LineRepository;
import subway.domain.repository.PassingRouteRepository;
import view.io.InputView;
import view.io.OutputView;
import subway.exception.SubwayRelatedException;
import subway.domain.Station;
import subway.domain.repository.StationRepository;
import validation.ValidationCheck;

public class StationAdminister {

    private static final String STATION_REGISTERED = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETED = "지하철 역이 삭제되었습니다.";
    private static final String STATION_LIST = "## 역 목록";

    public StationAdminister() {

    }

    public static void addStation() {
        try {
            String name = InputView.inputNewStationName();
            Station station = new Station(name);
            ValidationCheck.repeatedStationCheck(station);
            ValidationCheck.stationNameLengthCheck(station);
            StationRepository.addBack(station);
            OutputView.printAfterCommand(STATION_REGISTERED);
        } catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            addStation();
        }
    }

    public static void deleteStation() {
        try {
            String name = InputView.inputDeleteStationName();
            LineRepository.deleteStation(name);
            StationRepository.delete(name);
            OutputView.printAfterCommand(STATION_DELETED);
        } catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            deleteStation();
        }
    }

    public static void inquiryStations() {
        OutputView.printAllInfo(StationRepository.inquiryAllStations(), STATION_LIST);
    }

}
