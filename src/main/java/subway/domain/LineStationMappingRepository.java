package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineStationMappingRepository {
    private static final Map<Line, List<Station>> lineStationMapping = new HashMap<>();

    public static void createNewLine(String newLineName, String upEndStationName,
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

    public static void registerNewSection(String lineNameToRegisterSection,
        String stationNameToRegisterSection, String orderToRegisterSection) {
        Line lineToRegisterSection = LineRepository.findByName(lineNameToRegisterSection);
        Station stationToRegisterSection = StationRepository
            .findByName(stationNameToRegisterSection);
        List<Station> stationsToRegisterNewSection = lineStationMapping.get(lineToRegisterSection);
        stationsToRegisterNewSection
            .add(Integer.parseInt(orderToRegisterSection) - 1, stationToRegisterSection);
    }

    public static void deleteSection(String lineNameToDeleteSection,
        String stationNameToDeleteSection) {
        Line lineToDeleteSection = LineRepository.findByName(lineNameToDeleteSection);
        Station stationToDeleteSection = StationRepository.findByName(stationNameToDeleteSection);
        List<Station> stationsToDeleteSection = lineStationMapping.get(lineToDeleteSection);
        stationsToDeleteSection.remove(stationToDeleteSection);
    }
}
