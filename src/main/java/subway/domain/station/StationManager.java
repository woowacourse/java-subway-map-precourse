package subway.domain.station;

import subway.domain.State;
import subway.exception.AlreadyExistStationException;
import subway.exception.NoSuchStationException;
import subway.exception.StationContainException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationManager {
    public State addStation(State state, Scanner scanner) {
        if (state == State.STATION_ADD) {
            OutputView.printInputRegisterStation();
            addStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void addStation(String name) {
        if (StationRepository.isExistStation(name)) {
            throw new AlreadyExistStationException();
        }

        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public State removeStation(State state, Scanner scanner) {
        if (state == State.STATION_REMOVE) {
            OutputView.printInputRemoveStation();
            removeStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void removeStation(String name) {
        if (!StationRepository.isExistStation(name)) {
            throw new NoSuchStationException();
        }

        if (StationRepository.isContainStationInLine(name)) {
            throw new StationContainException();
        }

        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public State showStation(State state) {
        if (state == State.STATION_INQUIRY) {
            OutputView.printStationList(StationRepository.stations());

            return State.MAIN_SCENE;
        }

        return state;
    }
}
