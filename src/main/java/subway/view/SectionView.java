package subway.view;

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
            Line line = getLineOrThrow(DialogUtils.ask(scanner, Constants.ADD_SECTION_LINE_ASK));
            Station station =
                getStationOrThrow(DialogUtils.ask(scanner, Constants.ADD_SECTION_STATION_ASK));
            checkEmptySectionOrThrow(line, station);
            int index = InputUtils.parsePositiveIntOrThrow(
                DialogUtils.ask(scanner, Constants.ADD_SECTION_INDEX_ASK));
            checkValidationLengthOrThrow(line, index);

            subway.getSectionRepository().addSection(line, station, index);
            MessageUtils.printInfo(Constants.ADDED_SECTION);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void deleteSection() {
        try {
            String lineName = DialogUtils.ask(scanner, Constants.DELETE_SECTION_LINE_ASK);
            Line line = getLineOrThrow(lineName);
            String stationName = DialogUtils.ask(scanner, Constants.DELETE_SECTION_STATION_ASK);
            Station station = getStationOrThrow(stationName);
            checkExistSectionOrThrow(line, station);
            checkSectionMinLengthOrThrow(line);

            subway.getSectionRepository().deleteSection(line, station);
            MessageUtils.printInfo(Constants.DELETED_SECTION);
        } catch (Exception e) {
            MessageUtils.printError(e.getMessage());
        }
    }

    private void checkValidationLengthOrThrow(Line line, int index) {
        if (index > subway.getSectionRepository().getSize(line) + Constants.INDEX_ARRANGE_INT) {
            throw new RuntimeException(Constants.INVALID_INDEX);
        }
    }

    private void checkEmptySectionOrThrow(Line line, Station station) {
        if (subway.getSectionRepository().isExistStationInLine(line, station)) {
            throw new RuntimeException(Constants.EXIST_STATION);
        }
    }

    private void checkExistSectionOrThrow(Line line, Station station) {
        if (!subway.getSectionRepository().isExistStationInLine(line, station)) {
            throw new RuntimeException(Constants.NO_EXIST_SECTION);
        }
    }

    private void checkSectionMinLengthOrThrow(Line line) {
        if (Constants.MIN_SECTION_LENGTH_INT >= subway.getSectionRepository().getSize(line)) {
            throw new RuntimeException(Constants.INVALID_SECTION_MIN_LENGTH);
        }
    }

    private Line getLineOrThrow(String lineName) {
        Line line = subway.getLineRepository().findByName(lineName);
        if (line == null) {
            throw new RuntimeException(Constants.NO_EXIST_LINE);
        }
        return line;
    }

    private Station getStationOrThrow(String stationName) {
        Station station = subway.getStationRepository().findByName(stationName);
        if (station == null) {
            throw new RuntimeException(Constants.NO_EXIST_STATION);
        }
        return station;
    }
}