package subway.controller.station;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.exception.AlreadyExistStationException;
import subway.domain.exception.DuplicateStationOfLineException;
import subway.domain.exception.InvalidStationNameException;
import subway.domain.exception.NotExistStationException;
import subway.utils.InputValidator;
import subway.view.InputView;
import subway.view.outputview.StationOutputView;

public class StationFunction {
    public static StationRepository add() {
        StationOutputView.registerStationName();
        try {
            String station = InputView.input();
            StationRepository.addStation(new Station(station));
            StationOutputView.successAdd();
        } catch (AlreadyExistStationException | InvalidStationNameException e) {

        }
        return null;
    }

    public static StationRepository delete() {
        StationOutputView.deleteStationName();
        try {
            String station = InputView.input();
            InputValidator.validStationName(station);
            StationRepository.deleteStation(station);
        } catch (NotExistStationException | DuplicateStationOfLineException | InvalidStationNameException e) {

        }
        return null;
    }

    public static StationRepository printAll() {
        StationOutputView.showAllStations(StationRepository.stations());
        return null;
    }
}
