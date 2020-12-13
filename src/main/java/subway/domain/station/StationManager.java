package subway.domain.station;

import subway.domain.State;
import subway.exception.AlreadyExistStationException;
import subway.exception.NameLengthException;
import subway.exception.NoSuchStationException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationManager {
    private static final int NAME_LENGTH_MIN = 2;

    public static State addStation(State state, Scanner scanner) {
        if (state.equals(State.STATION_ADD)) {
            OutputView.printInputRegisterStation();
            addStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public static void addStation(String name) {
        if (StationRepository.isExistStation(name)) {
            throw new AlreadyExistStationException();
        }
        
        if (name.length() < NAME_LENGTH_MIN) {
            throw new NameLengthException();
        }

        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public static State removeStation(State state, Scanner scanner) {
        if (state.equals(State.STATION_REMOVE)) {
            OutputView.printInputRemoveStation();
            removeStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public static void removeStation(String name) {
        if (!StationRepository.isExistStation(name)) {
            throw new NoSuchStationException();
        }

        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public static State inquiryStation(State state) {
        if (state.equals(State.STATION_INQUIRY)) {
            OutputView.printStationList(StationRepository.stations());

            return State.MAIN_SCENE;
        }

        return state;
    }
}
