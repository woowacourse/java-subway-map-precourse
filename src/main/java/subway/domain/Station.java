package subway.domain;

import subway.domain.exception.ExistentNameException;
import subway.domain.exception.UnvalidNameLengthException;
import subway.view.InputView;
import subway.view.OutputView;

public class Station {
    private String name;
    private static final int MINIMUM_LENGTH = 2;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void add(InputView inputView, String stationMessage) {
        OutputView.printAddActionMessage(stationMessage);
        String newStationName = inputView.getInput();
        if (isValidStationName(newStationName)) {
            Station newStation = new Station(newStationName);
            StationRepository.addStation(newStation);
        }
    }

    private static boolean isValidStationName(String stationName) {
        try{
            validateStationName(stationName);
            return true;
        } catch (RuntimeException stationNameError) {
            System.out.println(stationNameError.getMessage());
            return false;
        }
    }

    private static boolean validateStationName(String stationName) {
        if (!StationRepository.validateNewName(stationName)) {
            throw new ExistentNameException();
        }
        if (!validateStationNameLength(stationName)) {
            throw new UnvalidNameLengthException();
        }
        return true;
    }

    private static boolean validateStationNameLength(String stationName) {
        if (stationName.length() >=  MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }
}
