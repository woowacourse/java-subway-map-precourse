package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board implements Menu {

    private final static String INFO = "[INFO]";

    private final static String ERROR = "[ERROR]";

    private final static List<String> initSections =
            List.of("2호선=교대역 강남역 역삼역", "3호선=교대역 남부터미널역 양재역", "신분당선=강남역 양재역 양재시민의숲역");

    private final static String MAIN_MENU_HELLO = "## 메인 화면";

    private final static String MANAGE_STATION_SELECT = "1";
    private final static String MANAGE_LINE_SELECT = "2";
    private final static String MANAGE_SECTION_SELECT = "3";
    private final static String PRINT_SUBWAY_SELECT = "4";
    private final static String QUIT_SELECT = "Q";

    private final static List<String> MENU_SELECTIONS =
            List.of(MANAGE_STATION_SELECT, MANAGE_LINE_SELECT, MANAGE_SECTION_SELECT, PRINT_SUBWAY_SELECT, QUIT_SELECT);

    private final static String MANAGE_STATION_EXPLAIN = "역 관리";
    private final static String MANAGE_LINE_EXPLAIN = "노선 관리";
    private final static String MANAGE_SECTION_EXPLAIN = "구간 관리";
    private final static String PRINT_SUBWAY_EXPLAIN = "지하철 노선도 출력";
    private final static String QUIT_EXPLAIN = "종료";

    private final static String SPLIT = ". ";

    private final static String MENU =
            "## 메인 화면\n" +
                    "1. 역 관리\n" +
                    "2. 노선 관리\n" +
                    "3. 구간 관리\n" +
                    "4. 지하철 노선도 출력\n" +
                    "Q. 종료\n";

    public Board() {
        for (String str : initSections) {
            setInitSection(str);
        }
    }

    @Override
    public void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(MAIN_MENU_HELLO).append("\n")
                .append(MANAGE_STATION_SELECT).append(SPLIT).append(MANAGE_STATION_EXPLAIN).append("\n")
                .append(MANAGE_LINE_SELECT).append(SPLIT).append(MANAGE_LINE_EXPLAIN).append("\n")
                .append(MANAGE_SECTION_SELECT).append(SPLIT).append(MANAGE_SECTION_EXPLAIN).append("\n")
                .append(PRINT_SUBWAY_SELECT).append(SPLIT).append(PRINT_SUBWAY_EXPLAIN).append("\n")
                .append(QUIT_SELECT).append(SPLIT).append(QUIT_EXPLAIN).append("\n");

        System.out.println(sb.toString());
    }

    private void setInitSection(String str) {
        String[] split = str.split("=");
        String lineName = split[0];
        List<Station> stations = Arrays.stream(split[1].split(" ")).map(Station::new).collect(Collectors.toList());

        Line line = new Line(lineName);
        LineRepository.addLine(line);

        for (Station station : stations) {
            StationRepository.addStation(station);
            line.addStation(station.getName());
        }
    }


}
