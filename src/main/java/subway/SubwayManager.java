package subway;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.OutputView;

public class SubwayManager implements Message {

    private static final int MIN_NAME_LENGTH = 3;
    private final Scanner scanner;

    SubwayManager(Scanner scanner) {
        this.scanner = scanner;

    }

    public void run() {
    }

    private void registerStation() {
        OutputView.printAnnouncement(ANN_REGISTER_STATION);
        try {
            Station newStation = generateStation();
            StationRepository.addStation(newStation);
            OutputView.printInfo(INFO_STATION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            registerStation();
        }
    }

    private Station generateStation() {
        String stationName = getStationName();
        validateStationName(stationName);
        return new Station(stationName);
    }

    private void deleteStation() {
        OutputView.printAnnouncement(ANN_DELETE_STATION);
        String stationName = getStationName();
        try {
            checkDeletableStation(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private void registerLine() {
        String lineName = getLineName();
        Line newLine = new Line(lineName);
        newLine.addFirst(getFirstStation());
        newLine.addLast(getLastStation());
        LineRepository.addLine(newLine);
        OutputView.printInfo(INFO_LINE_REGISTERED);
    }

    private Station getFirstStation() {
        OutputView.printAnnouncement(ANN_REGISTER_FIRST_STATION);
        Station firstStation;
        try {
            firstStation = getStation(getStationName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            firstStation = getFirstStation();
        }
        return firstStation;
    }

    private Station getLastStation() {
        OutputView.printAnnouncement(ANN_REGISTER_LAST_STATION);
        Station lastStation;
        try {
            lastStation = getStation(getStationName());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            lastStation = getLastStation();
        }
        return lastStation;
    }


    private Station getStation(String stationName) {
        if (!StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(stationName);
    }

    private String getLineName() {
        OutputView.printAnnouncement(ANN_REGISTER_LINE);
        String lineName = scanner.nextLine();
        try {
            validateLineName(lineName);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            lineName = getLineName();
        }
        return lineName;
    }

    private void validateLineName(String lineName) {
        if (lineName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_LINE_NAME_LENGTH);
        }
        if (LineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_LINE);
        }
    }

    private void checkDeletableStation(String stationName) {
        // TODO: 해당 역이 노선에 등록되어 있는지 확인

        if (!StationRepository.deleteStation(stationName)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
    }

    private String getStationName() {
        return scanner.nextLine().trim();
    }

    public void validateStationName(String stationName) {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME_LENGTH);
        }
        if (StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }


}
