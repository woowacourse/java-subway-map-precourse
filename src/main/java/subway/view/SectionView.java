package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.model.MenuGroup.Menu;
import subway.util.Constants;
import subway.util.DialogUtils;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class SectionView extends AbstractView {

    private Map<String, Runnable> menuActionMap;

    public SectionView(Subway subway, Scanner scanner) {
        super(subway, scanner);
    }

    @Override
    public void initView() {
        menuActionMap = Map.of(
            "1", this::insertSection,
            "2", this::deleteSection,
            Constants.BACKWARD_INPUT_CHARACTER, this::goBackward
        );
    }

    @Override
    public Menu getMenu() {
        return Constants.MENU_GROUPS.get(Constants.SECTION_MENU_STATE);
    }

    @Override
    public Map<String, Runnable> getMenuActionMap() {
        return menuActionMap;
    }

    private void insertSection() {
        try {
            Line line = getLineOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_SECTION_LINE_INPUT_COMMENT));
            Station station = getStationOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_SECTION_STATION_INPUT_COMMENT));
            checkEmptySectionOrThrow(line, station);
            int refinedIndex = InputUtils.getPositiveIntOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_SECTION_INDEX_INPUT_COMMENT));
            checkValidationLengthOrThrow(line, refinedIndex);

            subway.getSectionRepository().addSection(line, station, refinedIndex);
            MessageUtils.printInfo(Constants.ADD_SECTION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteSection() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.DELETE_SECTION_LINE_INPUT_COMMENT);
            Line line = getLineOrThrow(lineName);
            String stationName = DialogUtils.ask(
                scanner, Constants.DELETE_SECTION_STATION_INPUT_COMMENT);
            Station station = getStationOrThrow(stationName);
            checkExistSectionOrThrow(line, station);

            subway.getSectionRepository().deleteSection(line, station);
            MessageUtils.printInfo(Constants.DELETE_SECTION_OUTPUT_COMMENT);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void checkValidationLengthOrThrow(Line line, int index) {
        if (index > subway.getSectionRepository().getSize(line) + Constants.INDEX_ARRANGE_INT) {
            throw new RuntimeException(Constants.INVALID_LENGTH_ERROR_COMMENT);
        }
    }

    private void checkEmptySectionOrThrow(Line line, Station station) {
        if (isExistCheckStationInLine(line, station)) {
            throw new RuntimeException(Constants.EXIST_STATION_OUTPUT_COMMENT);
        }
    }

    private void checkExistSectionOrThrow(Line line, Station station) {
        if (!isExistCheckStationInLine(line, station)) {
            throw new RuntimeException(Constants.NO_EXIST_SECTION_OUTPUT_COMMENT);
        }
    }

    private Line getLineOrThrow(String lineName) {
        if (!isExistLine(lineName)) {
            throw new RuntimeException(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
        }
        return subway.getLineRepository().findByName(lineName);
    }

    private Station getStationOrThrow(String stationName) {
        if (!isExistStation(stationName)) {
            throw new RuntimeException(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
        }
        return subway.getStationRepository().findByName(stationName);
    }

    private boolean isExistLine(String lineName) {
        return subway.getLineRepository().findByName(lineName) != null;
    }

    private boolean isExistStation(String stationName) {
        return subway.getStationRepository().findByName(stationName) != null;
    }

    private boolean isExistCheckStationInLine(Line line, Station station) {
        List<Station> stations = subway.getSectionRepository().getStationListInLine(line);
        for (Station instanceStation : stations) {
            if (instanceStation.equals(station)) {
                return true;
            }
        }
        return false;
    }
}