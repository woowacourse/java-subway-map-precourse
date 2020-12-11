package subway.service;

import subway.constant.Constant;
import subway.constant.Information;
import subway.constant.InitialData;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.StationRepository;

import java.util.Scanner;

import static subway.constant.Information.INFO_HEADER;

public class StationService extends CrudService {

    private Scanner scanner;

    public StationService(Scanner scanner) {
        super(scanner, Information.STATION_INFO);
        this.scanner = scanner;
        initStations();
    }

    private void initStations() {
        StationRepository.addStation(InitialData.stations);
    }


    @Override
    public void add() {
        Station newStation = getNewStationInput();
        validateNewStation(newStation);
        StationRepository.addStation(newStation);
        System.out.println(Information.ADD_STATION_SUCCESS);
    }

    private Station getNewStationInput() {
        System.out.println(Information.ADD_STATION_INFO);
        return new Station(scanner.nextLine());
    }

    private void validateNewStation(Station newStation) {
        validateNameLength(newStation);
        validateDuplicateStation(newStation);
    }

    private void validateNameLength(Station newStation) {
        if (newStation.getName().length() < Constant.MIN_NAME_LENGTH)
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_NAME_LENGTH);
    }

    private void validateDuplicateStation(Station newStation) {
        if (StationRepository.stations().contains(newStation))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.DUPLICATE_STATION);
    }


    @Override
    public void delete() {
        System.out.println(Information.DELETE_STATION_INFO);
    }


    @Override
    public void show() {
        System.out.print(Information.SHOW_STATION_INFO);
        for (Station station : StationRepository.stations())
            System.out.print(INFO_HEADER + station.getName());
        System.out.println();
    }
}
