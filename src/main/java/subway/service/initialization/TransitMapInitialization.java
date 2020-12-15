package subway.service.initialization;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.TransitMapRepository;
import subway.type.StationType;

import java.util.*;

/**
 * TransitMapInitialization.java : 지하철 노선도 초기화에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class TransitMapInitialization {
    private static final List<Station> stations = StationRepository.stations();

    public static void initializeTransitMaps() {
        List<Line> lines = getInitializationLines();
        List<LinkedList<Station>> lineStations = getInitializationStations();

        for (int i = 0; i < lines.size(); i++) {
            TransitMapRepository.addTransitMap(new TransitMap(lines.get(i), lineStations.get(i)));
        }
    }

    public static List<Line> getInitializationLines() {
        return LineRepository.lines();
    }

    public static List<LinkedList<Station>> getInitializationStations() {
        List<LinkedList<Station>> lineStations = new ArrayList<>();
        LinkedList<Station> lineTwoStations = new LinkedList<>();
        LinkedList<Station> lineThreeStations = new LinkedList<>();
        LinkedList<Station> lineShinbundangStations = new LinkedList<>();

        for (Station station : stations) {
            getLineTwoStations(station, lineTwoStations);
            getLineThreeStations(station, lineThreeStations);
            getLineShinbundangStations(station, lineShinbundangStations);
        }

        lineStations.add(lineTwoStations);
        lineStations.add(lineThreeStations);
        lineStations.add(lineShinbundangStations);
        return lineStations;
    }

    public static void getLineTwoStations(Station station, List<Station> lineTwoStations) {
        String stationName = station.getName();

        if (stationName.equals(StationType.EDUCATION_UNIVERSITY.getStation())) {
            lineTwoStations.add(station);
        }
        if (stationName.equals(StationType.GANGNAM.getStation())) {
            lineTwoStations.add(station);
        }
        if (stationName.equals(StationType.YEOKSAM.getStation())) {
            lineTwoStations.add(station);
        }
    }

    public static void getLineThreeStations(Station station, List<Station> lineThreeStations) {
        String stationName = station.getName();

        if (stationName.equals(StationType.EDUCATION_UNIVERSITY.getStation())) {
            lineThreeStations.add(station);
        }
        if (stationName.equals(StationType.NAMBU_BUS_TERMINAL.getStation())) {
            lineThreeStations.add(station);
        }
        if (stationName.equals(StationType.YANGJAE.getStation())) {
            lineThreeStations.add(station);
        }
        if (stationName.equals(StationType.MAEBONG.getStation())) {
            lineThreeStations.add(station);
        }
    }

    public static void getLineShinbundangStations(Station station, List<Station> lineShinbundangStations) {
        String stationName = station.getName();

        if (stationName.equals(StationType.GANGNAM.getStation())) {
            lineShinbundangStations.add(station);
        }
        if (stationName.equals(StationType.YANGJAE.getStation())) {
            lineShinbundangStations.add(station);
        }
        if (stationName.equals(StationType.YANGJAE_CITIZENS_FOREST.getStation())) {
            lineShinbundangStations.add(station);
        }
    }
}
