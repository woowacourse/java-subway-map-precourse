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
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String SECTION_LINE = "---";
    private static final String MENU_PREFIX = "## ";
    private static final String MAIN_MENU_MESSAGE = "메인화면 \n"
        + "1. 역 관리 \n"
        + "2. 노선 관리 \n"
        + "3. 구간 관리 \n"
        + "4. 지하철 노선도 출력 \n"
        + "Q. 종료\n";
    private static final String STATION_MENU_MESSAGE = "역 관리 화면 \n"
        + "1. 역 등록 \n"
        + "2. 역 삭제 \n"
        + "3. 역 조회 \n"
        + "B. 돌아가기 \n";
    private static final String LINE_MENU_MESSAGE = "노선 관리 화면 \n"
        + "1. 노선 등록 \n"
        + "2. 노선 삭제 \n"
        + "3. 노선 조회 \n"
        + "B. 돌아가기 \n";
    private static final String SECTION_MENU_MESSAGE = "구간 관리 화면\n"
        + "1. 구간 등록\n"
        + "2. 구간 삭제\n"
        + "B. 돌아가기\n";
    private static final String MENU_CATEGORY_CHOICE_MESSAGE = "원하는 기능을 선택하세요.";

    private static final String INPUT_STATION_NAME_MESSAGE = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_CHECK_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String REMOVE_STATION_NAME_MESSAGE = "삭제할 역 이름을 입력하세요.";
    private static final String REMOVE_STATION_CHECK_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static final String SHOW_STATION_LIST_MESSAGE = "역 목록";

    private static final String INPUT_LINE_NAME_MESSAGE = "등록할 노선의 이름을 입력하세요.";
    private static final String INPUT_LINE_START_STATION_NAME_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_END_STATION_NAME_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_CHECK_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String REMOVE_LINE_NAME_MESSAGE = "삭제할 노선 이름을 입력하세요.";
    private static final String REMOVE_LINE_CHECK_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String SHOW_LINE_LIST_MESSAGE = "노선 목록";

    private static final String INPUT_SECTION_LINE_MESSAGE = "노선을 입력하세요.";
    private static final String INPUT_SECTION_STATION_MESSAGE = "역이름을 입력하세요.";
    private static final String INPUT_SECTION_POSITION_MESSAGE = "순서를 입력하세요.";
    private static final String INPUT_SECTION_CHECK_MESSAGE = "구간이 등록되었습니다.";
    private static final String REMOVE_SECTION_LINE_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    private static final String REMOVE_SECTION_STATION_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    private static final String REMOVE_SECTION_CHECK_MESSAGE = "구간이 삭제되었습니다.";

    private static final String SUBWAY_LINEMAP = "지하철 노선도";

    private static void showInfoMessage(String message) {
        System.out.println(INFORMATION_PREFIX + message);
    }

    public static String showErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
        return message;
    }
    private static void showMenuMessage(String message){
        showMessage(message);
        showMessage(MENU_CATEGORY_CHOICE_MESSAGE);
    }

    private static void showMessage(String message){
        System.out.println(MENU_PREFIX+message);
    }

    public static void showMainMenu() {
        showMenuMessage(MAIN_MENU_MESSAGE);
    }

    public static void showStationMenu() {
        showMenuMessage(STATION_MENU_MESSAGE);
    }

    public static void showLineMenu() {
        showMenuMessage(LINE_MENU_MESSAGE);
    }

    public static void showSectionMenu() {
        showMenuMessage(SECTION_MENU_MESSAGE);
    }

    public static void guideInsertStation() {
        showMessage(INPUT_STATION_NAME_MESSAGE);
    }

    public static void doneInsertStation() {
        showInfoMessage(INPUT_STATION_CHECK_MESSAGE);
    }

    public static void guideRemoveStation() {
        showMessage(REMOVE_STATION_NAME_MESSAGE);
    }

    public static void doneRemoveStation() {
        showInfoMessage(REMOVE_STATION_CHECK_MESSAGE);
    }

    public static void showStationList(List<Station> stations) {
        showInfoMessage(SHOW_STATION_LIST_MESSAGE);
        stations.forEach(station -> showInfoMessage(station.getName()));
    }

    public static void guideInsertLine() {
        showMessage(INPUT_LINE_NAME_MESSAGE);
    }

    public static void guideStartStationOfLine(){
        showMessage(INPUT_LINE_START_STATION_NAME_MESSAGE);
    }

    public static void guideEndStationOfLine(){
        showMessage(INPUT_LINE_END_STATION_NAME_MESSAGE);
    }

    public static void doneInsertLine() {
        showInfoMessage(INPUT_LINE_CHECK_MESSAGE);
    }

    public static void guideRemoveLine() {
        showMessage(REMOVE_LINE_NAME_MESSAGE);
    }

    public static void doneRemoveLine() {
        showInfoMessage(REMOVE_LINE_CHECK_MESSAGE);
    }

    public static void showLineList(List<Line> lines) {
        showInfoMessage(SHOW_LINE_LIST_MESSAGE);
        lines.forEach(line -> showInfoMessage(line.getName()));
    }

    public static void guideInsertSectionLineName(){
        showMessage(INPUT_SECTION_LINE_MESSAGE);
    }

    public static void guideInsertSectionStationName(){
        showMessage(INPUT_SECTION_STATION_MESSAGE);
    }

    public static void guideInsertSectionPostionName(){
        showMessage( INPUT_SECTION_POSITION_MESSAGE);
    }

    public static void doneInsertSection(){
        showInfoMessage(INPUT_SECTION_CHECK_MESSAGE);
    }

    public static void guideRemoveSectionLineName(){
        showMessage(REMOVE_SECTION_LINE_MESSAGE);
    }

    public static void guideRemoveSectionStationName(){
        showMessage(REMOVE_SECTION_STATION_MESSAGE);
    }

    public static void doneRemoveSection(){
        showInfoMessage(REMOVE_SECTION_CHECK_MESSAGE);
    }

    public static void showSection(Line line) {
        showInfoMessage(line.getName());
        showInfoMessage(SECTION_LINE);
        showStationList(line.getSections());
        System.out.println();
    }

    public static void showSubwayLineMap() {
        showMessage(SUBWAY_LINEMAP);
        LineRepository.lines().forEach(OutputView::showSection);
    }

}
