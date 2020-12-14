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
    public static StationRepository add(StationRepository stationRepository) {
        StationOutputView.registerStationName();
        try {
            String station = InputView.input();
            stationRepository.addStation(new Station(station));
            StationOutputView.successAdd();
        } catch (AlreadyExistStationException | InvalidStationNameException e) {

        }
        return null;
    }

    public static StationRepository delete(StationRepository stationRepository) {
        StationOutputView.deleteStationName();
        try {
            String station = InputView.input();
            InputValidator.validStationName(station);
            stationRepository.deleteStation(station);
        } catch (NotExistStationException | DuplicateStationOfLineException | InvalidStationNameException e) {

        }
        return null;
    }

    public static StationRepository printAll(StationRepository stationRepository) {
        StationOutputView.showAllStations(stationRepository.stations());
        return null;
    }
}
