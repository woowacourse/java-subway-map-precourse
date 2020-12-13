package subway.domain;

import subway.domain.exception.ExistentNameException;
import subway.domain.exception.RegisteredStationException;
import subway.domain.exception.UnvalidNameLengthException;
import subway.domain.exception.NonExistentNameException;
import subway.domain.exception.SameBoundStationException;
import subway.view.InputView;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import subway.view.OutputView;

public class Line {
    private String name;
    private static final int MINIMUM_LENGTH = 2;
    private static final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addStation(Station station) {
        stations.add(station);
    }

    private void addStationByName(String stationName) {
        for (int i = 0; i < StationRepository.stations().size(); i++) {
            Station station = StationRepository.stations().get(i);
            if (station.getName().equals(stationName)) {
                addStation(station);
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

    public static void add(InputView inputView, String lineMessage, String stationMessage) {
        OutputView.printAddActionMessage(lineMessage);
        String newLineName = inputView.getInput();
        if (validateAddLineName(newLineName, lineMessage)) {
            List<String> boundStations = getBoundsStation(inputView, stationMessage);
            Line newLine = new Line(newLineName);
            newLine.setBoundStations(boundStations);
            LineRepository.addLine(newLine);
        }
        OutputView.printAddActionFinishMessage(lineMessage);
    }

    public static void delete(InputView inputView, String lineMessage) {
        OutputView.printDeleteActionMessage(lineMessage);
        String deleteLineName = inputView.getInput();
        if (validateExistentLineName(deleteLineName, lineMessage)) {
            LineRepository.deleteLineByName(deleteLineName);
            OutputView.printDeleteActionFinishMessage(lineMessage);
        }
    }

    public static void printList(String lineMessage) {
        OutputView.printList(lineMessage, getLineNameList());
    }

    private static List<String> getLineNameList() {
        List<String> lineNames = new ArrayList<String>();
        List<Line> lines = LineRepository.lines();
        for (int i = 0; i < lines.size(); i++) {
            lineNames.add(lines.get(i).getName());
        }
        return lineNames;
    }

    private static boolean validateAddLineName(String stationName, String lineMessage) {
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

    private static List<String> getBoundsStation(InputView inputView, String stationMessage) {
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

    private void setBoundStations(List<String> boundStations) {
        for (int i = 0; i < boundStations.size(); i++) {
            addStationByName(boundStations.get(i));
        }
    }

    private static boolean validateExistentStation(String boundStationName) {
        if (StationRepository.validateNewName(boundStationName)) {
            return false;
        }
        return true;
    }
}
