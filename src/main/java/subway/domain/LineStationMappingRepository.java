package subway.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import subway.common.print.Prefix;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.function.printsubwaymap.printer.PrintSubwayMapPrinter;

public class LineStationMappingRepository {
    private static final int ONE_INDEX = 1;
    private static final Map<Line, List<Station>> lineStationMapping = new LinkedHashMap<>();

    public static void createNewLineByStations(String newLineName, Station upEndStation,
        Station downEndStation) {
        Line newLine = new Line(newLineName);
        LineRepository.addLine(newLine);
        lineStationMapping.put(newLine, new ArrayList<>() {
            {
                add(upEndStation);
                add(downEndStation);
            }
        });
    }

    public static void createNewLineByStationNames(String newLineName, String upEndStationName,
        String downEndStationName) {
        Line newLine = new Line(newLineName);
        Station upEndStation = StationRepository.findByName(upEndStationName);
        Station downEndStation = StationRepository.findByName(downEndStationName);
        LineRepository.addLine(newLine);
        lineStationMapping.put(newLine, new ArrayList<>() {
            {
                add(upEndStation);
                add(downEndStation);
            }
        });
    }

    public static void deleteLine(String lineNameToDeleteInput) {
        Line lineToDelete = LineRepository.findByName(lineNameToDeleteInput);
        lineStationMapping.remove(lineToDelete);
        LineRepository.deleteLineByName(lineNameToDeleteInput);
    }

    public static void registerNewSectionByLineAndStation(Line lineToRegisterSection,
        Station stationToRegisterSection, int orderToRegisterSection) {
        List<Station> stationsToRegisterNewSection = lineStationMapping.get(lineToRegisterSection);
        stationsToRegisterNewSection
            .add(orderToRegisterSection - ONE_INDEX, stationToRegisterSection);
    }

    public static void registerNewSectionByName(String lineNameToRegisterSection,
        String stationNameToRegisterSection, String orderToRegisterSection) {
        Line lineToRegisterSection = LineRepository.findByName(lineNameToRegisterSection);
        Station stationToRegisterSection = StationRepository
            .findByName(stationNameToRegisterSection);
        List<Station> stationsToRegisterNewSection = lineStationMapping.get(lineToRegisterSection);
        stationsToRegisterNewSection
            .add(Integer.parseInt(orderToRegisterSection) - ONE_INDEX,
                stationToRegisterSection);
    }

    public static void deleteSection(Line lineToDeleteSection,
        Station stationToDeleteSection) {
        List<Station> stationsToDeleteSection = lineStationMapping.get(lineToDeleteSection);
        stationsToDeleteSection.remove(stationToDeleteSection);
    }

    public static void printAllSubwayMap() {
        for (Line line : lineStationMapping.keySet()) {
            System.out.println(Prefix.INFO_PREFIX + line.getName());
            System.out.println(Prefix.INFO_PREFIX + PrintSubwayMapPrinter.SPLIT_LINE);
            for (Station station : lineStationMapping.get(line)) {
                System.out.println(Prefix.INFO_PREFIX + station.getName());
            }
            System.out.println();
        }
    }

    public static boolean isStationNameRegisteredInLine(String stationName) {
        for (Line line : lineStationMapping.keySet()) {
            if (isStationNameInLine(lineStationMapping.get(line), stationName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStationNameInLine(List<Station> stations, String stationName) {
        return stations.stream().map(Station::getName).anyMatch(name -> name.equals(stationName));
    }

    public static int lineSize(Line line) {
        return lineStationMapping.get(line).size();
    }

    public static boolean isStationRegisteredInThatLine(Station stationToRegisterSection,
        Line lineToRegisterSection) {
        for (Station stationInLine : lineStationMapping.get(lineToRegisterSection)) {
            if (stationInLine.getName().equals(stationToRegisterSection.getName())) {
                return true;
            }
        }
        return false;
    }
}
