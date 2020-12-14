package subway;

public class DataInitService {

    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String SOUTH_TERMIANL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";
    private static final String LINE_TOW = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static final int ONE = 1;
    private static final int TWO = 2;

    public static void init() {
        addStation();
        addLine();
        addSections();
    }

    private static void addStation() {
        String[] StationNames = {GYODAE_STATION, GANGNAM_STATION, YEOKSAM_STATION,
            SOUTH_TERMIANL_STATION, YANGJAE_STATION, YANGJAE_CITIZEN_FOREST_STATION,
            MAEBONG_STATION};
        for (String stationName : StationNames) {
            StationService.addStation(stationName, false);
        }
    }

    private static void addLine() {

    }

    private static void addSections() {

    }

}
