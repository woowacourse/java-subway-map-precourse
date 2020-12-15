package subway.service;

import subway.constant.Constant;
import subway.constant.Information;
import subway.constant.InitialData;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.constant.Information.ADD_STATION_SUCCESS;
import static subway.constant.Information.DELETE_STATION_SUCCESS;

public class StationService extends CrudService {

    public StationService(InputView inputView, OutputView outputView) {
        super(inputView, outputView, Information.STATION_INFO);
        initStations();
    }

    private void initStations() {
        StationRepository.addStation(InitialData.stations);
    }


    @Override
    public void add() {
        Station newStation = getInputView().getNewStationInput();
        validateNewStation(newStation);
        StationRepository.addStation(newStation);
        getOutputView().printInformation(ADD_STATION_SUCCESS);
    }


    private void validateNewStation(Station newStation) {
        validateNameLength(newStation);
        validateDuplicateStationExists(newStation);
    }

    private void validateNameLength(Station newStation) {
        if (newStation.getName().length() < Constant.MIN_NAME_LENGTH)
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_NAME_LENGTH);
    }

    private void validateDuplicateStationExists(Station newStation) {
        if (StationRepository.stations().contains(newStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.DUPLICATE_STATION);
    }


    @Override
    public void delete() {
        Station targetStation = getInputView().getTargetStationInput();
        validateTargetStation(targetStation);
        StationRepository.deleteStationByName(targetStation.getName());
        getOutputView().printInformation(DELETE_STATION_SUCCESS);
    }

    private void validateTargetStation(Station targetStation) {
        validateTargetStationExists(targetStation);
        validateTargetStationIsNotLinked(targetStation);
    }

    private void validateTargetStationExists(Station targetStation) {
        if (!StationRepository.stations().contains(targetStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }

    private void validateTargetStationIsNotLinked(Station targetStation) {
        for (Line line : LineRepository.lines())
            validateTargetStationIsNotInLine(line, targetStation);
    }

    private void validateTargetStationIsNotInLine(Line line, Station targetStation) {
        if (line.getStations().contains(targetStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.STATION_LINKED);
    }


    @Override
    public void show() {
        getOutputView().printStationList();
    }
}
