package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.exceptions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LineService {
    public static List<Line> getLines() {
        return LineRepository.getLines();
    }

    public static Optional<Line> getLine(String lineName) {
        return LineRepository.getLine(lineName);
    }

    public static void addLine(String name, Station startStation, Station endStation) {
        if (checkIfLineExist(name)) {
            throw new DuplicatedLineNameException();
        }
        if (startStation.equals(endStation)) {
            throw new DuplicatedStartAndEndStationNameException();
        }
        Line line = new Line(name);
        line.addStation(0, startStation);
        line.addStation(1, endStation);
        LineRepository.addLine(line);
    }

    public static void removeLine(String name) {
        if (!checkIfLineExist(name)) {
            throw new LineNotExistException();
        }
        LineRepository.deleteLineByName(name);
    }

    public static Optional<Station> getStationInLine(String stationName){
        List<Line> lines = LineRepository.getLines();
        List<Station> stationList = lines.stream()
                .flatMap(line -> line.getStations().stream())
                .filter(stationInLines -> stationInLines.getName().equals(stationName))
                .collect(Collectors.toList());
        if (stationList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(stationList.get(0));
    }

    public static void addStationInLine(Station station, Line line, int position) {
        if (position > line.getStations().size() + 1 || position <= 0) {
            throw new InvalidPositionException();
        }
        line.addStation(position - 1, station);
    }

    public static void removeStationInLine(Station station, Line line) {
        if (line.getStations().size() <= 2) {
            throw new MinimumLineLengthException();
        }
        if (!line.getStations().contains(station)) {
           throw new StationNotExistInLineException();
        }
        line.removeStation(station);
    }

    private static boolean checkIfLineExist(String name) {
        if (LineRepository.getLine(name).isPresent()) {
            return true;
        }
        return false;
    }
}
