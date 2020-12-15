package subway.administer.repository.adminisiter;

import view.io.InputView;
import view.io.OutputView;
import subway.exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.repository.LineRepository;
import subway.domain.Station;
import subway.domain.repository.StationRepository;
import validation.ValidationCheck;

public class PassingRouteAdminister {

    private static final String INTERVAL_REGISTERED = "구간이 등록되었습니다.";
    private static final String INTERVAL_DELETED = "구간이 삭제되었습니다.";
    private static final String SUBWAY_ROUTES = "## 지하철 노선도";
    public PassingRouteAdminister() {

    }

    public static void addInterval() {
        try {
            String lineName = InputView.inputLineName();
            Line line = LineRepository.searchLine(lineName);
            String stationName = InputView.inputStationName();
            Station station = StationRepository.searchStation(stationName);
            ValidationCheck.RegisteredIntervalCheck(line, station);
            int order = InputView.inputOrder();
            line.getPassingRoutes().add(order, station);
            OutputView.printAfterCommand(INTERVAL_REGISTERED);
        }
        catch (SubwayRelatedException e) {
            OutputView.printErrorMessage(e.getMessage());
            addInterval();
        }
    }

    public static void deleteInterval() {
        try {
            String[] info = InputView.inputDeleteIntervalInfo();
            Line line = LineRepository.searchLine(info[0]);
            Station station = StationRepository.searchStation(info[1]);
            line.passingRoutes.delete(station);
            OutputView.printAfterCommand(INTERVAL_DELETED);
        }
        catch (SubwayRelatedException e){
            OutputView.printErrorMessage(e.getMessage());
            deleteInterval();
        }
    }

    public static void inquiryAllRoutes() {
        OutputView.printAllInfo(LineRepository.inquiryAllStations(), SUBWAY_ROUTES);
    }

}
