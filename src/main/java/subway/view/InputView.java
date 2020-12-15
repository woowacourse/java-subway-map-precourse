package subway.view;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import subway.constant.BoundaryCheckDigit;
import subway.constant.BoundaryCheckPattern;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InputView {

    private InputView() {

    }

    /**
     * 데이터 입력 기본 포맷
     */
    public static String scanData(Scanner scanner) {

        return scanner.nextLine();
    }

    public static String scanMainMenu(Scanner scanner) {
        String choiceMainMenuOption;

        do { // 유효한 값이 올 때 까지 값을 입력받는다.
            OutputView.optionChoicePrint();
            choiceMainMenuOption = scanner.nextLine();
        } while (!mainMenuValidCheck(choiceMainMenuOption));

        return choiceMainMenuOption;
    }

    private static boolean mainMenuValidCheck(String choiceMainMenuOption) {
        if (Pattern.matches(
            BoundaryCheckPattern.MAIN_MENU_OPTION_LIMIT.getRegexBoundaryCheckPattern(),
            choiceMainMenuOption)) {
            return true;
        }

        OutputView.notSelectableError();
        return false;
    }

    public static String scanStationMenu(Scanner scanner) {
        String choiceStationMenuOption;

        do { // 유효한 값이 올 때 까지 값을 입력받는다.
            OutputView.optionChoicePrint();
            choiceStationMenuOption = scanner.nextLine();
        } while (!stationMenuValidCheck(choiceStationMenuOption));

        return choiceStationMenuOption;
    }

    private static boolean stationMenuValidCheck(String choiceStationMenuOption) {
        if (Pattern.matches(
            BoundaryCheckPattern.STATION_MENU_OPTION_LIMIT.getRegexBoundaryCheckPattern(),
            choiceStationMenuOption)) {
            return true;
        }

        OutputView.notSelectableError();
        return false;
    }

    public static String scanStationAddName(Scanner scanner) {
        String stationName;

        OutputView.stationAddGuidePrint();
        stationName = scanner.nextLine();

        if (isStationNameCountUpLimit(stationName)) {
            OutputView.stationAddFailPrint();
            throw new IllegalArgumentException();
        }

        if (isNotStationNameDuplication(stationName)) {
            OutputView.stationDuplicationFailPrint();
            throw new IllegalArgumentException();
        }
        OutputView.stationAddSuccessPrint();
        return stationName;
    }

    private static boolean isStationNameCountUpLimit(String stationName) {
        return stationName.length() < BoundaryCheckDigit.STATION_ADD_LIMIT_MINIMUM
            .getBoundaryCheckDigit();
    }

    private static boolean isNotStationNameDuplication(String stationName) {
        return StationRepository.stations()
            .stream()
            .map(Station::getName)
            .collect(Collectors.toList())
            .contains(stationName);
    }

    public static String scanStationDeleteName(Scanner scanner) {
        String stationName;

        OutputView.stationDeleteGuidePrint();
        stationName = scanner.nextLine();

        return stationName;
    }

    public static String scanLineMenu(Scanner scanner) {
        String choiceLineMenu;

        do { // 유효한 값이 올 때 까지 값을 입력받는다.
            OutputView.optionChoicePrint();
            choiceLineMenu = scanner.nextLine();
        } while (!lineMenuValidCheck(choiceLineMenu));

        return choiceLineMenu;
    }

    private static boolean lineMenuValidCheck(String choiceLineMenu) {
        if (Pattern.matches(
            BoundaryCheckPattern.LINE_MENU_OPTION_LIMIT.getRegexBoundaryCheckPattern(),
            choiceLineMenu)) {
            return true;
        }

        OutputView.notSelectableError();
        return false;
    }

    public static String scanLineAddName(Scanner scanner) {

        String lineName = scanner.nextLine();

        if (isLineNameDuplication(lineName)) {
            OutputView.lineNameDuplicationFailPrint();
            throw new IllegalArgumentException();
        }

        if (isLineNameBelowLimit(lineName.length())) {
            OutputView.lineNameCountLimitFailPrint();
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    private static boolean isLineNameBelowLimit(int length) {
        return length < BoundaryCheckDigit.LINE_ADD_LIMIT.getBoundaryCheckDigit();
    }

    private static boolean isLineNameDuplication(String lineName) {
        return LineRepository.getAllLineNames().contains(lineName);
    }

    public static String scanStationName(Scanner scanner) {
        String TerminusName = scanner.nextLine();
        if (stationRepositoryHaveStation(TerminusName)) {
            return TerminusName;
        }
        OutputView.lineAddFailPrint();
        throw new IllegalArgumentException();
    }

    private static boolean stationRepositoryHaveStation(String stationName) {
        return StationRepository.contains(stationName);
    }

    public static String scanLineDeleteName(Scanner scanner) {
        String lineName;

        OutputView.lineDeleteGuidePrint();
        lineName = scanner.nextLine();

        return lineName;
    }

    public static String scanSectionMenu(Scanner scanner) {
        String choiceMenu;

        do { // 유효한 값이 올 때 까지 값을 입력받는다.
            OutputView.optionChoicePrint();
            choiceMenu = scanner.nextLine();
        } while (!sectionMenuValidCheck(choiceMenu));

        return choiceMenu;
    }

    private static boolean sectionMenuValidCheck(String choiceMenu) {
        if (Pattern.matches(
            BoundaryCheckPattern.SECTION_MENU_OPTION_LIMIT.getRegexBoundaryCheckPattern(),
            choiceMenu)) {
            return true;
        }

        OutputView.notSelectableError();
        return false;
    }

    public static String scanSectionLineName(Scanner scanner) {
        String lineName = scanner.nextLine();
        if (!LineRepository.contains(lineName)) {
            OutputView.sectionNotFoundLineError();
            throw new IllegalArgumentException();
        }
        return lineName;
    }

    public static String scansectionStationName(Scanner scanner) {
        String stationName = scanner.nextLine();
        if (!StationRepository.contains(stationName)) {
            OutputView.sectionNotFoundStationError();
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    public static int scanSectionAddIndex(Scanner scanner, Line line) {
        String indexString = scanner.nextLine();
        int index;
        if (isNotDigit(indexString)) {
            OutputView.isNotDigitPrint();
            throw new IllegalArgumentException();
        }

        index = Integer.parseInt(indexString);

        if (indexOutOfRange(line,index)) {
            OutputView.outOfRange();
            throw new IllegalArgumentException();
        }

        return index;
    }

    private static boolean isNotDigit(String indexString) {
        return !Pattern
            .matches(BoundaryCheckPattern
                .IS_DIGIT
                .getRegexBoundaryCheckPattern(), indexString);
    }

    private static boolean indexOutOfRange(Line line,int index){
        return line.length() < index;
    }
}
