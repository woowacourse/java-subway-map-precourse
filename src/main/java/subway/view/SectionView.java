package subway.view;

import java.util.Scanner;
import subway.Subway;
import subway.util.Constants;
import subway.util.InputUtils;
import subway.util.MessageUtils;

public class SectionView {

    public static String menuSelector(Scanner userInput) {
        String input = userInput.next();
        String thisMenuState = Constants.SECTION_MENU_STATE;
        if (input.equals("1")) {
            System.out.println("대충 구간 등록 한다는 내용");
            insertSection(userInput);
        }
        if (input.equals("2")) {
            System.out.println("대충 구간 삭제 한다는 내용");
            deleteSection(userInput);
        }
        if (input.toLowerCase().equals("b")) {
            thisMenuState = Constants.MAIN_MENU_STATE;
        }
        if (!(input.equals("1") || input.equals("2") || input.equals("3") || input
            .toLowerCase()
            .equals("b"))) {
            MessageUtils.printError(Constants.INVALID_STRING_OUTPUT_COMMENT);
        }
        return thisMenuState;
    }

    private static boolean insertSection(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_LINE_INPUT_COMMENT);
        String sectionTitle = userInput.next();
        MessageUtils.printInputAnnouncement(Constants.ADD_SECTION_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
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

    private static boolean insertByName(String sectionTitle, String stationName,
        String indexString) {
        int index = Integer.parseInt(indexString);
        int listSize = Subway.Map.getSize(Subway.lines.findByName(sectionTitle));
        if (index <= listSize) {
            Subway.Map.addSection(Subway.lines.findByName(sectionTitle),
                Subway.stations.findByName(stationName), index);
            MessageUtils.printInfo(Constants.ADD_SECTION_OUTPUT_COMMENT);
            return true;
        }
        return false;
    }

    private static boolean checkExistInInsertSection(String sectionTitle, String stationName,
        String indexString) {
        if (!LineView.isExistLineName(sectionTitle)) {
            MessageUtils.printError(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }
        if (!StationView.isExistStationName(stationName)) {
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

    private static boolean checkValidationSectionListLength(String sectionTitle,
        String indexString) {
        if (Integer.parseInt(indexString) > Subway.Map
            .getSize(Subway.lines.findByName(sectionTitle))) {
            MessageUtils.printError(Constants.INVALID_LENGTH_ERROR_COMMENT);
            return false;
        }
        return true;
    }


    private static boolean deleteSection(Scanner userInput) {
        MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_LINE_INPUT_COMMENT);
        String sectionTitle = userInput.next();
        MessageUtils.printInputAnnouncement(Constants.DELETE_SECTION_STATION_INPUT_COMMENT);
        String stationName = userInput.next();
        if (Subway.lines.findByName(sectionTitle) == null) {
            MessageUtils.printError(Constants.NO_EXIST_LINE_OUTPUT_COMMENT);
            return false;
        }
        if (Subway.stations.findByName(stationName) == null) {
            MessageUtils.printError(Constants.NO_EXIST_STATION_OUTPUT_COMMENT);
            return false;
        }
        Subway.Map.deleteSection(Subway.lines.findByName(sectionTitle),
            Subway.stations.findByName(stationName));
        return true;
    }

}
