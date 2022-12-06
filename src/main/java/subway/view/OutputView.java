package subway.view;

import static subway.domain.LineRepository.lines;
import static subway.domain.SectionRepository.getLineIndex;
import static subway.domain.SectionRepository.sections;
import static subway.domain.StationRepository.stations;

import java.util.List;
import subway.domain.Line;

public class OutputView {

    private final String PREFIX = System.lineSeparator() + "## ";
    private final String PREFIX_ERROR = System.lineSeparator() + "[ERROR] ";
    private final String PREFIX_INFO = "[INFO] ";
    private final String DELIMITER = "---";
    private final String STATION_LIST = "역 목록";
    private final String LINE_LIST = "노선 목록";
    private final String SUBWAY_MAP_LIST = "지하철 노선도";

    //메뉴 조회
    public void printMenu(List<String> menu) {
        System.out.println();
        menu.forEach(System.out::println);
    }

    //역 조회
    public void printStationList() {
        System.out.println(PREFIX + STATION_LIST);
        stations().forEach(station -> System.out.println(PREFIX_INFO + station));
    }

    //노선 조회
    public void printLineList() {
        System.out.println(PREFIX + LINE_LIST);
        lines().forEach(line -> System.out.println(PREFIX_INFO + line));
    }

    //원하는 기능 선택 출력
    public void printSelectFunction(String selectFunction) {
        System.out.println(selectFunction);
    }

    //에러 출력
    public void printError(IllegalArgumentException e) {
        System.out.println(PREFIX_ERROR + e.getMessage());
    }

    //INFO 메시지 출력
    public void printNotificationMessage(String message) {
        System.out.println(System.lineSeparator() + PREFIX_INFO + message);
    }

    //지하철 노선도 조회
    public void printSubwayMap() {
        System.out.println(PREFIX + SUBWAY_MAP_LIST);
        for (Line line : lines()) {
            System.out.println(PREFIX_INFO + line.getName());
            System.out.println(PREFIX_INFO + DELIMITER);
            sections().get(getLineIndex(line))
                    .forEach(section ->
                            System.out.println(PREFIX_INFO + section));
            System.out.println();
        }
    }
}
