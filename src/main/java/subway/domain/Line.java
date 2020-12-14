package subway.domain;

import subway.domain.exception.ExistentNameException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.SameBoundStationException;
import subway.domain.exception.UnvalidNameLengthException;
import subway.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import subway.view.OutputView;
import java.util.Set;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    private static final int ORDER_CONSTANT = 1;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addStation(Station station, int order) {
        int indexOrder = order - ORDER_CONSTANT;
        stations.add(indexOrder,station);
    }

    public void addStationByName(String stationName, int order) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            Station station = StationRepository.stations().get(i);
            if (station.getName().equals(stationName)) {
                addStation(station, order);
            }
        }
    }

    private void deleteStation(Station station) {
        stations.remove(station);
    }

    public void deleteStationByName(String stationName) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            Station station = StationRepository.stations().get(i);
            if (station.getName().equals(stationName)) {
                deleteStation(station);
            }
        }
    }

    public boolean validateNewName(String stationName) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateAddLineName(String stationName, String lineMessage) {
        if (!LineRepository.validateNewLineName(stationName)) {
            throw new ExistentNameException(lineMessage);
        }
        if (!validateLineNameLength(stationName)) {
            throw new UnvalidNameLengthException();
        }
        return true;
    }

    public static boolean validateExistentLineName(String lineName, String lineMessage) {
        if (LineRepository.validateNewLineName(lineName)) {
            throw new NonExistentNameException(lineMessage);
        }
        return true;
    }

    private static boolean validateLineNameLength(String stationName) {
        if (stationName.length() >=  MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }

    public static List<String> getBoundsStation(InputView inputView, String stationMessage) {
        OutputView.printUpBoundStationMessage();
        String upBoundStationName = inputView.getInput();
        validateBoundStation(upBoundStationName, stationMessage);
        OutputView.printDownBoundStationMessage();
        String downBoundStationName = inputView.getInput();
        validateBoundStation(downBoundStationName, stationMessage);
        List<String> boundStations = Arrays.asList(upBoundStationName, downBoundStationName);
        validateSameBoundStations(boundStations);
        return boundStations;
    }

    private static boolean validateBoundStation(String boundStationName, String stationMessage) {
        if (!validateExistentStation(boundStationName)) {
            throw new NonExistentNameException(stationMessage);
        }
        return true;
    }

    private static boolean validateSameBoundStations(List<String> boundStations) {
        Set<String> boundStationSet = new HashSet<String>(boundStations);
        if (boundStationSet.size() != boundStations.size()) {
            throw new SameBoundStationException();
        }
        return true;
    }

    public void setBoundStations(List<String> boundStations) {
        for (int i = 0; i < boundStations.size(); i++) {
            int order = stations.size() + ORDER_CONSTANT;
            addStationByName(boundStations.get(i), order);
        }
    }

    private static boolean validateExistentStation(String boundStationName) {
        if (StationRepository.validateNewName(boundStationName)) {
            return false;
        }
        return true;
    }

    public boolean validateRange(int order) {
        if (order > this.stations.size()+1) {
            return false;
        }
        return true;
    }

    public void runLineMap() {
        for (int i = 0; i < this.stations.size(); i++) {
            Station station = this.stations.get(i);
            OutputView.printLineMapElement(station.getName());
        }
    }
}
