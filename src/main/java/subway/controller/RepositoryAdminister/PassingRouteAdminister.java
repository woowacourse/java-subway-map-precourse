package subway.controller.RepositoryAdminister;

import View.InputView;
import View.OutputView;
import subway.Exception.SubwayRelatedException;
import subway.domain.Line;
import subway.domain.subRepository.LineRepository;
import subway.domain.Station;
import subway.domain.subRepository.StationRepository;
import Validation.SubwayValidation;

public class PassingRouteAdminister {

    private static final String INTERVAL_REGISTERED = "구간이 등록되었습니다.";
    private static final String INTERVAL_DELETED = "구간이 삭제되었습니다.";

    public PassingRouteAdminister() {

    }

    public static void addInterval() {
        try {
            String lineName = InputView.inputLineName();
            String stationName = InputView.inputStationName();
            int order = InputView.inputOrder();
            Line line = LineRepository.searchLine(lineName);
            Station station = StationRepository.searchStation(stationName);
            SubwayValidation.RegisteredIntervalCheck(line, station);
            line.passingRoutes.add(order, station);
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

}
