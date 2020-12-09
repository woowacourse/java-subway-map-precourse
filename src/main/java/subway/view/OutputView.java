package subway.view;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

/**
 * 결과에 따른 출력을 하는 클래스
 */
public class OutputView {

    private static final String INFORMATION_PREFIX = "[INFO] ";
    private static final String INPUT_LINE_CHECK_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String REMOVE_LINE_CHECK_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String SHOW_LINE_LIST_MESSAGE = "노선 목록";
    private static final String SECTION_LINE = "---";
    private static final String INPUT_SECTION_CHECK_MESSAGE = "구간이 등록되었습니다.";
    private static final String REMOVE_SECTION_CHECK_MESSAGE = "구간이 삭제되었습니다.";
    private static final String REMOVE_STATION_CHECK_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static final String SHOW_STATION_LIST_MESSAGE = "역 목록";
    private static final String INPUT_STATION_CHECK_MESSAGE = "지하철 역이 등록되었습니다.";

    public void showInfoMessage(String message) {
        System.out.println(INFORMATION_PREFIX + message);
    }

    public void showStationList(List<Station> stations) {
        System.out.println(INFORMATION_PREFIX + SHOW_STATION_LIST_MESSAGE);
        stations.forEach(station -> showInfoMessage(station.getName()));
    }

    public void doneInsertStation(){
        showInfoMessage(INPUT_STATION_CHECK_MESSAGE);
    }

    public void showLineList(List<Line> lines) {
        System.out.println(INFORMATION_PREFIX + SHOW_LINE_LIST_MESSAGE);
        lines.forEach(line -> showInfoMessage(line.getName()));
    }

    public void showSection(Line line) {
        showInfoMessage(line.getName());
        showInfoMessage(SECTION_LINE);
        showStationList(line.getSection());
        System.out.println();
    }

    public void showSubwaySections() {
        LineRepository.lines().forEach(this::showSection);
    }

}
