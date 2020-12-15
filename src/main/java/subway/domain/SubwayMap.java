package subway.domain;

public class SubwayMap {
    private static final String LINE_NUMBER_TWO = "2호선";
    private static final String LINE_NUMBER_THREE = "3호선";
    private static final String LINE_NEW_BOONDANG = "신분당선";
    private static final String GYODAE_STATION = "교대역";
    private static final String GANGNAM_STATION = "강남역";
    private static final String YEOKSAM_STATION = "역삼역";
    private static final String NAMBU_TERMINAL_STATION = "남부터미널역";
    private static final String YANGJAE_STATION = "양재역";
    private static final String YANGJAE_CITIZEN_FOREST_STATION = "양재시민의숲역";
    private static final String MAEBONG_STATION = "매봉역";

    private Line lineNumberTwo;
    private Line lineNumberThree;
    private Line lineNewBoondang;
    private Station gyodaeStation;
    private Station gangnamStation;
    private Station yeoksamStation;
    private Station nambuTerminalStation;
    private Station yangjaeStation;
    private Station yangjaeCitizenForestStation;
    private Station maebongStation;

    public SubwayMap() {
        initialize();
    }

    public void initialize() {
        initializeLine();
        initializeStation();
        initializeMap();
    }

    private void initializeLine() {
        lineNumberTwo = new Line(LINE_NUMBER_TWO);
        lineNumberThree = new Line(LINE_NUMBER_THREE);
        lineNewBoondang = new Line(LINE_NEW_BOONDANG);
        LineRepository.addLine(lineNumberTwo);
        LineRepository.addLine(lineNumberThree);
        LineRepository.addLine(lineNewBoondang);
    }

    private void initializeStation() {
        gyodaeStation = new Station(GYODAE_STATION);
        gangnamStation = new Station(GANGNAM_STATION);
        yeoksamStation = new Station(YEOKSAM_STATION);
        nambuTerminalStation = new Station(NAMBU_TERMINAL_STATION);
        yangjaeStation = new Station(YANGJAE_STATION);
        yangjaeCitizenForestStation = new Station(YANGJAE_CITIZEN_FOREST_STATION);
        maebongStation = new Station(MAEBONG_STATION);
        StationRepository.addStation(gyodaeStation);
        StationRepository.addStation(gangnamStation);
        StationRepository.addStation(yeoksamStation);
        StationRepository.addStation(nambuTerminalStation);
        StationRepository.addStation(yangjaeStation);
        StationRepository.addStation(yangjaeCitizenForestStation);
        StationRepository.addStation(maebongStation);
    }

    private void initializeMap() {
        lineNumberTwo.registerStation(gyodaeStation);
        lineNumberTwo.registerStation(gangnamStation);
        lineNumberTwo.registerStation(yeoksamStation);
        lineNumberThree.registerStation(gyodaeStation);
        lineNumberThree.registerStation(nambuTerminalStation);
        lineNumberThree.registerStation(yangjaeStation);
        lineNumberThree.registerStation(maebongStation);
        lineNewBoondang.registerStation(gangnamStation);
        lineNewBoondang.registerStation(yangjaeStation);
        lineNewBoondang.registerStation(yangjaeCitizenForestStation);
    }

}
