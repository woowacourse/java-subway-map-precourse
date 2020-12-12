package subway.view;

import static subway.view.TextFixtures.*;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.exception.SubwayCustomException;

public class OutputView {

    private static void showInfoMessage(String message) {
        System.out.println(INFORMATION_PREFIX + message);
    }

    public static void showErrorMessage(SubwayCustomException exception) {
        System.out.println(exception.getMessage() + System.lineSeparator());
    }

    private static void showMenuMessage(String message) {
        showMessage(message);
    }

    public static void showMessage(String message) {
        System.out.println(MENU_PREFIX + message);
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

    public static void chooseCategory() {
        showMessage(MENU_CATEGORY_CHOICE_MESSAGE);
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

    public static void showStationList() {
        showInfoMessage(SHOW_STATION_LIST_MESSAGE);
        StationRepository.stations()
            .forEach(station -> showInfoMessage(station.getName()));
    }

    public static void guideInsertLine() {
        showMessage(INPUT_LINE_NAME_MESSAGE);
    }

    public static void guideStartStationOfLine() {
        showMessage(INPUT_LINE_START_STATION_NAME_MESSAGE);
    }

    public static void guideEndStationOfLine() {
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

    public static void showLineList() {
        showInfoMessage(SHOW_LINE_LIST_MESSAGE);
        LineRepository.lines().forEach(line -> showInfoMessage(line.getName()));
    }

    public static void guideInsertSectionLineName() {
        showMessage(INPUT_SECTION_LINE_MESSAGE);
    }

    public static void guideInsertSectionStationName() {
        showMessage(INPUT_SECTION_STATION_MESSAGE);
    }

    public static void guideInsertSectionPostionName() {
        showMessage(INPUT_SECTION_POSITION_MESSAGE);
    }

    public static void doneInsertSection() {
        showInfoMessage(INPUT_SECTION_CHECK_MESSAGE);
    }

    public static void guideRemoveSectionLineName() {
        showMessage(REMOVE_SECTION_LINE_MESSAGE);
    }

    public static void guideRemoveSectionStationName() {
        showMessage(REMOVE_SECTION_STATION_MESSAGE);
    }

    public static void doneRemoveSection() {
        showInfoMessage(REMOVE_SECTION_CHECK_MESSAGE);
    }

    public static void showSection(Line line) {
        showInfoMessage(line.getName());
        showInfoMessage(SECTION_LINE);
        line.getSections().forEach(section -> showInfoMessage(section.getName()));
        System.out.println();
    }

    public static void showSubwayLineMap() {
        showMessage(SUBWAY_LINE_MAP);
        LineRepository.lines().forEach(OutputView::showSection);
    }

}
