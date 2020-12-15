package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class ManagementInitializer {

    // station
    public static final String KYODAE_STATION = "교대역";
    public static final String KANGNAM_STATION = "강남역";
    public static final String YANGJAE_STATION = "양재역";
    public static final String YEOKSAM_STATION = "역삼역";
    public static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    public static final String MAEBONG_STATION = "매봉역";
    public static final String YANGJAE_CITIZEN_STATION = "양재시민의숲역";

    // line
    public static final String SECOND_LINE = "2호선";
    public static final String THIRD_LINE = "3호선";
    public static final String SINBUNDANG_LINE = "신분당선";

    public static ManagementController initialize() {
        String[] stations = {KYODAE_STATION, KANGNAM_STATION, YEOKSAM_STATION,
                NAMBU_TERMINAL_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_STATION, MAEBONG_STATION};

        StationRepository stationRepository = new StationRepository()
                .addStations(stations);

        String[] secondLine = {KYODAE_STATION, KANGNAM_STATION, YEOKSAM_STATION};
        String[] thirdLine = {KYODAE_STATION, NAMBU_TERMINAL_STATION, YANGJAE_STATION,
                MAEBONG_STATION};
        String[] sinbundangLine = {KANGNAM_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_STATION};

        LineRepository lineRepository = new LineRepository()
                .addLine(SECOND_LINE, secondLine)
                .addLine(THIRD_LINE, thirdLine)
                .addLine(SINBUNDANG_LINE, sinbundangLine);

        return new ManagementController(lineRepository, stationRepository);
    }
}
