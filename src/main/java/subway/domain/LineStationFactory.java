package subway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineStationFactory {
    private static final Map<Line, List<Station>> lineStation = new HashMap<>();

    public static Map<Line, List<Station>> init() {
        initStation();
        initLine();
        return lineStation;
    }

    private static void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("수원역"));
    }

    private static void initLine() {
        Line line_2 = new Line("2호선");
        LineRepository.addLine(line_2);
        initLineStation(line_2, new String[]{"교대역", "강남역", "역삼역"});

        Line line_3 = new Line("3호선");
        LineRepository.addLine(line_3);
        initLineStation(line_3, new String[]{"교대역", "남부터미널역", "양재역", "매봉역"});

        Line line_sinBunDang = new Line("신분당선");
        LineRepository.addLine(line_sinBunDang);
        initLineStation(line_sinBunDang, new String[]{"강남역", "양재역", "양재시민의숲역"});
    }

    private static void initLineStation(Line line, String[] stationName) {
        for (String name : stationName) {
            addLineStation(line, StationRepository.findStation(name).get());
        }
    }

    private static void addLineStation(Line K, Station V){
        lineStation.computeIfAbsent(K, Ve->new ArrayList<Station>()).add(V);
    }
}