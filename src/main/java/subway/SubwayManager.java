package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayManager implements Message {


    public void run() {
        registerStation();
        registerStation();
        OutputView.printStations();
        registerLine();
        OutputView.printLines();
    }


    private void registerStation() {
        Station station = generateStation();
        StationRepository.addStation(station);
        OutputView.printInfo(INFO_STATION_REGISTERED);
    }

    private Station generateStation() {
        try {
            String name = InputView.getStationName();
            return new Station(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateStation();
        }
    }

    private void deleteStation() {
        OutputView.printAnnouncement(ANN_DELETE_STATION);
        String stationName = InputView.getInput();
        try {
            StationRepository.deleteStation(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private void registerLine() {
        Line newLine = generateLine();
        newLine.addFirst(getFirstStation());
        newLine.addLast(getLastStation());
        LineRepository.addLine(newLine);
        OutputView.printInfo(INFO_LINE_REGISTERED);
    }

    private Line generateLine() {
        try {
            String name = InputView.getLineName();
            return new Line(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateLine();
        }
    }

    private void deleteLine() {
        OutputView.printAnnouncement(ANN_DELETE_LINE);
        String name = InputView.getInput();
        if (LineRepository.deleteLineByName(name)) {
            OutputView.printInfo(INFO_LINE_DELETED);
            return;
        }
        OutputView.printError(ERROR_NOT_REGISTERED_LINE);
    }

    private Station getFirstStation() {
        OutputView.printAnnouncement(ANN_REGISTER_FIRST_STATION);
        try {
            String name = InputView.getInput();
            return getStation(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getFirstStation();
        }
    }

    private Station getLastStation() {
        OutputView.printAnnouncement(ANN_REGISTER_LAST_STATION);
        try {
            String name = InputView.getInput();
            return getStation(name);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getLastStation();
        }
    }

    private Station getStation(String stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(stationName);
    }

}
