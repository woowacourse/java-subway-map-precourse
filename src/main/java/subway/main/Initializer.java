package subway.main;

import java.util.ArrayList;
import java.util.List;
import subway.domain.LineStationMappingRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class Initializer {
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZENS_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";
    private static final String LINE_2 = "2호선";
    private static final String LINE_3 = "3호선";
    private static final String SINBUNDANG_LINE = "신분당선";
    private static final String SECOND_ORDER = "2";
    private static final List<String> STATION_NAMES = new ArrayList<>() {
        {
            add(GYODAE_STATION);
            add(GANGNAM_STATION);
            add(YEOKSAM_STATION);
            add(NAMBU_TERMINAL_STATION);
            add(YANGJAE_STATION);
            add(YANGJAE_CITIZENS_FOREST_STATION);
            add(MAEBONG_STATION);
        }
    };

    public static void initialize() {
        registerStations();
        registerLines();
        registerSections();
    }

    private static void registerSections() {
        LineStationMappingRepository
            .registerNewSectionByName(LINE_2, GANGNAM_STATION, SECOND_ORDER);
        LineStationMappingRepository
            .registerNewSectionByName(LINE_3, YANGJAE_STATION, SECOND_ORDER);
        LineStationMappingRepository
            .registerNewSectionByName(LINE_3, NAMBU_TERMINAL_STATION, SECOND_ORDER);
        LineStationMappingRepository
            .registerNewSectionByName(SINBUNDANG_LINE, YANGJAE_STATION, SECOND_ORDER);
    }

    private static void registerLines() {
        LineStationMappingRepository
            .createNewLineByStationNames(LINE_2, GYODAE_STATION, YEOKSAM_STATION);
        LineStationMappingRepository
            .createNewLineByStationNames(LINE_3, GYODAE_STATION, MAEBONG_STATION);
        LineStationMappingRepository
            .createNewLineByStationNames(SINBUNDANG_LINE, GANGNAM_STATION, YANGJAE_CITIZENS_FOREST_STATION);
    }

    private static void registerStations() {
        for (String stationName : STATION_NAMES) {
            StationRepository.addStation(new Station(stationName));
        }
    }
}
