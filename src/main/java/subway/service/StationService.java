package subway.service;

import subway.constant.Constant;
import subway.constant.Function;
import subway.constant.Information;
import subway.constant.InitialData;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.StationRepository;

import java.util.Scanner;

import static subway.constant.Information.INFO_HEADER;

public class StationService {

    private Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
        initStations();
    }

    private void initStations() {
        StationRepository.addStation(InitialData.stations);
    }

    public void run() {
        try {
            String selectedFunction = selectFunction();
            runSelectedFunction(selectedFunction);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String selectFunction() {
        String line = getFunctionInput();
        Function.validate(line);
        return line;
    }

    private String getFunctionInput() {
        System.out.println(Information.STATION_INFO);
        return scanner.nextLine();
    }

    private void runSelectedFunction(String selectedFunction) {
        if (selectedFunction.equals(Function.ADD.getCode()))
            addNewStation();
        if (selectedFunction.equals(Function.DELETE.getCode()))
            deleteStation();
        if (selectedFunction.equals(Function.SHOW.getCode()))
            showStations();
    }

    private void addNewStation() {
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

    private void deleteStation() {
        System.out.println(Information.DELETE_STATION_INFO);
    }

    private void showStations() {
        System.out.print(Information.SHOW_STATION_INFO);
        for (Station station : StationRepository.stations())
            System.out.print(INFO_HEADER + station.getName());
        System.out.println();
    }
}
