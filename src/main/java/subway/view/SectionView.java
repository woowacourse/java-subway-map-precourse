package subway.view;

import java.util.List;
import java.util.Scanner;
import subway.Subway;
import subway.domain.Line;
import subway.domain.Station;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class SectionView {

    private Subway subway;
    private Scanner userInput;

    public SectionView(Subway subway, Scanner scanner) {
        this.subway = subway;
        this.userInput = scanner;
    }

    public String menuSelector(Scanner userInput) {
        String input = userInput.next();
        MessageUtils.printBlankLine();
        String thisMenuState = Constants.SECTION_MENU_STATE;
        if (input.equals("1")) {
            this.insertSection(userInput);
        }
        if (input.equals("2")) {
            this.deleteSection(userInput);
        }
        if (input.equalsIgnoreCase(Constants.BACKWARD_INPUT_CHARACTER)) {
            thisMenuState = Constants.MAIN_MENU_STATE;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input
            .equalsIgnoreCase(Constants.BACKWARD_INPUT_CHARACTER))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    private boolean insertSection(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_LINE_INPUT_COMMENT);
        String sectionTitle = userInput.next();
        MessageUtils.printBlankLine();
        MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        MessageUtils.printBlankLine();
        MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_INDEX_INPUT_COMMENT);
        String indexString = userInput.next();
        if (!checkExistInInsertSection(sectionTitle, stationName, indexString)) {
            return false;
        }
        if (!insertByName(sectionTitle, stationName, indexString)) {
            return false;
        }
        return true;
    }

    private boolean insertByName(String sectionTitle, String stationName,
        String indexString) {
        int index = Integer.parseInt(indexString);
        if (!InputUtils.isPositiveInt(index)) {
            MessageUtils.printError(Constants.INVALID_LENGTH_ERROR_COMMENT);
            return false;
        }
        int listSize = subway.getSectionRepository()
            .getSize(subway.getLineRepository().findByName(sectionTitle));
        if (index <= listSize) {
            subway.getSectionRepository()
                .addSection(subway.getLineRepository().findByName(sectionTitle),
                    subway.getStationRepository().findByName(stationName), index);
            MessageUtils.printInfo(Constants.ADD_SECTION_OUTPUT_COMMENT);
            return true;
        }
        return false;
    }

    private boolean checkExistInInsertSection(String sectionTitle, String stationName,
        String indexString) {
        if (isExistStationInLine(subway.getLineRepository().findByName(sectionTitle),
            subway.getStationRepository().findByName(stationName))) {
            MessageUtils.printError(Constants.EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }

        if (!isExistLineName(sectionTitle)) {
            MessageUtils.printError(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }

        if (!isExistStationName(stationName)) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
            return false;
        }

        if (!InputUtils.isValidateInt(indexString)) {
            MessageUtils.printError(Constants.INVALID_STRING_ERROR_COMMENT);
            return false;
        }
        if (!checkValidationSectionListLength(sectionTitle, indexString)) {
            return false;
        }
        return true;
    }

    private boolean isExistStationName(String sectionTitle) {
        if (sectionTitle == null) {
            return false;
        }
        if (subway.getLineRepository().findByName(sectionTitle) != null) {
            return true;
        }
        return false;
    }

    public boolean isExistStationInLine(Line sectionTitle, Station station) {
        if (sectionTitle == null || station == null) {
            return false;
        }
        List<Station> stations = subway.getSectionRepository().getStationListInLine(sectionTitle);
        for (Station instanceStation : stations) {
            if (instanceStation.equals(station)) {
                return true;
            }
        }
        return false;
    }

    private boolean isExistLineName(String sectionTitle) {
        if (sectionTitle == null) {
            return false;
        }
        if (subway.getLineRepository().findByName(sectionTitle) != null) {
            return true;
        }
        return false;
    }

    private boolean checkValidationSectionListLength(String sectionTitle,
        String indexString) {
        if (Integer.parseInt(indexString) > subway.getSectionRepository()
            .getSize(subway.getLineRepository().findByName(sectionTitle))) {
            MessageUtils.printError(Constants.INVALID_LENGTH_ERROR_COMMENT);
            return false;
        }
        return true;
    }

    private boolean deleteSection(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_LINE_INPUT_COMMENT);
        String sectionTitle = userInput.next();
        MessageUtils.printBlankLine();
        MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        MessageUtils.printBlankLine();
        if (subway.getLineRepository().findByName(sectionTitle) == null) {
            MessageUtils.printError(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }
        if (subway.getStationRepository().findByName(stationName) == null) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
            return false;
        }
        if (!isExistStationInLine(subway.getLineRepository().findByName(sectionTitle),
            subway.getStationRepository().findByName(stationName))) {
            MessageUtils.printError(Constants.NO_EXIST_SECTION_OUTPUT_COMMENT);
            return false;
        }
        if (subway.getStationRepository().findByName(stationName) != null
            && subway.getStationRepository().findByName(stationName) != null) {
            subway.getSectionRepository()
                .deleteSection(subway.getLineRepository().findByName(sectionTitle),
                    subway.getStationRepository().findByName(stationName));
            MessageUtils.printInfo(Constants.DELETE_SECTION_OUTPUT_COMMENT);
            return true;
        }
        return false;
    }
}