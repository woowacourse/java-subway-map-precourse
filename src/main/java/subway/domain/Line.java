package subway.domain;

import subway.utils.Util;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    private static final int ERROR = -1;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        if (name.length() < MINIMUM_LENGTH) {
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public List<Station> getStations() {
        return stations;
    }

    public void addStations(String[] stationNames) {
        for (String station : stationNames) {
            stations.add(new Station(station));
        }
    }

    public boolean isExistStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addStation(String stationName) {
        if (stationName.length() < MINIMUM_LENGTH) {
            ErrorView.nameLengthError();
            return false;
        }
        stations.add(StationRepository.ifNotExistRegister(stationName));
        return true;
    }

    public void status() {
        for (Station station : stations) {
            OutputView.status(station.getName());
        }
        OutputView.space();
    }

    public boolean addStationByIndex(String stationName, Scanner scanner) {
        if (stationName.length() < MINIMUM_LENGTH) {
            ErrorView.nameLengthError();
            return false;
        }
        if (isExistStation(stationName)) {
            ErrorView.duplicateName();
            return false;
        }
        OutputView.writeOrderNumber();
        int orderNumber = orderNumber(scanner.next());
        if (orderNumber == ERROR) {
            return false;
        }
        stations.add(orderNumber, StationRepository.ifNotExistRegister(stationName));
        return true;
    }

    private int orderNumber(String stringNumber) {
        if (!Util.isNumber(stringNumber)) {
            return ERROR;
        }
        int orderNumber = Integer.parseInt(stringNumber);
        if (orderNumber == 0 || orderNumber > stations.size()+1) {
            ErrorView.writeAppropriateNumber();
            return ERROR;
        }
        return orderNumber - 1;
    }

    public boolean deleteStation(Scanner scanner) {
        if(stations.size() <= MINIMUM_LENGTH){
            ErrorView.lineSizeError();
            return false;
        }
        OutputView.writeDeleteStation();
        String stationName = scanner.next();
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
                stations.remove(i);
                return true;
            }
        }
        ErrorView.notExistName();
        return false;
    }
}
