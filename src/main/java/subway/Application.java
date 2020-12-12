package subway;

import com.sun.tools.javac.Main;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

public class Application {

    enum MainFunction {
        STATION_MANAGEMENT('1'), LINE_MANAGEMENT('2'), SECTION_MANAGEMENT('3'), SUBWAY_MAP(
            '4'), QUIT('Q');

        final private char menu;

        MainFunction(char menu) {
            this.menu = menu;
        }

        public char getMenu() {
            return menu;
        }
    }

    enum StationFunction {
        ADD('1'), DELETE('2'), INQUIRY('3'), GET_BACK('B');

        final private char menu;

        StationFunction(char menu) {
            this.menu = menu;
        }

        public char getMenu() {
            return menu;
        }

        public boolean matchMenu(char menu) {
            if (this.menu == menu) {
                return true;
            }
            return false;
        }

    }

    enum LineFunction {
        ADD('1'), DELETE('2'), INQUIRY('3'), GET_BACK('B');

        final private char menu;

        LineFunction(char menu) {
            this.menu = menu;
        }

        public char getMenu() {
            return menu;
        }

        public boolean matchMenu(char menu) {
            if (this.menu == menu) {
                return true;
            }
            return false;
        }

    }

    private static StationRepository stationRepository;
    private static LineRepository lineRepository;
    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    private static final List<String> initialStationList = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();
        stationRepository = new StationRepository();
        lineRepository = new LineRepository();
        char mainFunction;

        initializeStation();
        while (true) {
            mainFunction = mainMenu();
            if (mainFunction == MainFunction.QUIT.getMenu()) {
                break;
            }
            selectDetailMenu(mainFunction);
        }
    }

    private static void initializeStation() {
        for (String stationList : initialStationList) {
            stationRepository.addStation(new Station(stationList));
        }
    }

    private static char mainMenu() {
        printUtils.printMainMenu();
        printUtils.printSelectFunction();
        return inputUtils.inputFunctionSelect(4, MainFunction.QUIT.getMenu());
    }

    private static void selectDetailMenu(char menu) {
        if (menu == MainFunction.STATION_MANAGEMENT.getMenu()) {
            stationManagementMenu();
        }
        if (menu == MainFunction.LINE_MANAGEMENT.getMenu()) {
            lineManagementMenu();
        }
        if (menu == MainFunction.SECTION_MANAGEMENT.getMenu()) {
            sectionManagementMenu();
        }
        if (menu == MainFunction.SUBWAY_MAP.getMenu()) {
            subwayMapPrint();
        }

    }

    private static void stationManagementMenu() {
        printUtils.printStationManagementMenu();
        printUtils.printSelectFunction();

        char menu = inputUtils.inputFunctionSelect(3, StationFunction.GET_BACK.getMenu());
        if (StationFunction.GET_BACK.matchMenu(menu)) {
            return;
        }
        if (StationFunction.ADD.matchMenu(menu)) {
            addStation();
        }
        if (StationFunction.DELETE.matchMenu(menu)) {
            deleteStation();
        }
        if (StationFunction.INQUIRY.matchMenu(menu)) {
            inquiryStationList();
        }
    }

    private static void addStation() {
        printUtils.printAddStationGuide();
        try {
            Station newStation = new Station(inputUtils.inputStationName());
            if (stationRepository.isStationExist(newStation)) {
                throw new IllegalArgumentException();
            }
            stationRepository.addStation(newStation);
            printUtils.printCompleteAddStation();
        } catch (IllegalArgumentException e) {
            printUtils.duplicateStationError();
            addStation();
            return;
        }
    }

    private static void deleteStation() {
        printUtils.printDeleteStationGuide();
        try {
            Station delStation = new Station(inputUtils.inputStationName());
            if (!stationRepository.isStationExist(delStation)) {
                throw new IllegalArgumentException();
            }
            stationRepository.deleteStation(delStation.getName());
            printUtils.printCompleteDeleteStation();
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
            deleteStation();
            return;
        }
    }

    private static void inquiryStationList() {
        printUtils.printStationsList();
        stationRepository.printStationsList();
    }

    private static void lineManagementMenu() {
        printUtils.printLineManagementMenu();
        printUtils.printSelectFunction();

        char menu = inputUtils.inputFunctionSelect(3, LineFunction.GET_BACK.getMenu());
        if (LineFunction.GET_BACK.matchMenu(menu)) {
            return;
        }
        if (LineFunction.ADD.matchMenu(menu)) {
            addLine();
        }
    }

    private static void addLine() {
        registerNewLine();
        String upboundStation = upboundTerminal();
        String downboundStation = downboundTerminal(upboundStation);
        printUtils.printCompleteAddLine();
    }

    private static void registerNewLine() {
        printUtils.printAddNewLineNameGuide();
        try {
            Line newline = new Line(inputUtils.inputLineName());
            if (lineRepository.isLineExist(newline)) {
                throw new IllegalArgumentException();
            }
            lineRepository.addLine(newline);
        } catch (IllegalArgumentException e) {
            printUtils.duplicateLineError();
            registerNewLine();
        }
    }

    private static String upboundTerminal() {
        printUtils.printUpboundTerminalNameGuide();
        try {
            String upboundStation = inputUtils.inputStationName();
            if (!stationRepository.isStationExist(new Station(upboundStation))) {
                throw new IllegalArgumentException();
            }
            return upboundStation;
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
            return upboundTerminal();
        }
    }

    private static String downboundTerminal(String upboundStation) {
        printUtils.printDownboundTerminalNameGuide();
        try {
            String downboundStation = inputUtils.inputStationName();
            if (!stationRepository.isStationExist(new Station(downboundStation))) {
                throw new IllegalArgumentException();
            }
            if(upboundStation.equals(downboundStation))
                throw new InputMismatchException();
            return downboundStation;
        } catch (IllegalArgumentException e) {
            printUtils.nonExistentStationError();
        }catch (InputMismatchException e){
            printUtils.sameTerminalNameError();
        }
        return downboundTerminal(upboundStation);
    }

    private static void sectionManagementMenu() {

    }

    private static void subwayMapPrint() {

    }
}
