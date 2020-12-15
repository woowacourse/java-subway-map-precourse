package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubwayIntializer {
    private static final List<String> initialStationNames = new ArrayList<>(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
    private static final Map<String, List<String>> initialRoutes = new LinkedHashMap<>();
    static {
        initialRoutes.put("2호선", new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역")));
        initialRoutes.put("3호선", new ArrayList<>(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")));
        initialRoutes.put("신분당선", new ArrayList<>(Arrays.asList("강남역", "양재역", "양재시민의숲역")));
    }
    
    public static void initialize() {
        initializeStations();
        initializeLines();
        initializeRoutes();
    }
    
    private static void initializeStations() {
        for (String stationName : initialStationNames) {
            StationRepository.addStation(new Station(stationName));
        }
    }
    
    private static void initializeLines() {
        initialRoutes.forEach((lineName, stationNames) -> LineRepository.addLine(new Line(lineName)));
    }
    
    private static void initializeRoutes() {
        initialRoutes.forEach((lineName, stationNames) -> stationNames.stream()
                .forEachOrdered(stationName -> LineRepository.addStationToRouteByName(lineName, stationName)));
    }
}
