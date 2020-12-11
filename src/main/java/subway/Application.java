package subway;

import com.sun.tools.javac.Main;
import java.util.List;
import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

public class Application {

    enum MainFunction {
        STATION_MANAGEMENT('1'), LINE_MANAGEMENT('2'), SECTION_MANAGEMENT('3'), SUBWAY_MAP(
            '4'), QUIT('Q');

        final private char menu;

        MainFunction(char menu){this.menu=menu;}

        public char getMenu(){return menu;}
    }

    enum StationFunction {
        ADD('1'), DELETE('2'), INQUIRY('3'), GET_BACK('B');

        final private char menu;

        StationFunction(char menu){this.menu=menu;}

        public char getMenu(){return menu;}

        public boolean matchMenu(char menu){
            if(this.menu==menu)return true;
            return false;
        }

    }

    private static StationRepository stationRepository;
    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();
        stationRepository = new StationRepository();
        char mainFunction;

        while (true) {
            mainFunction = mainMenu();
            if (mainFunction == MainFunction.QUIT.getMenu()) {
                break;
            }
            selectDetailMenu(mainFunction);
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

        char menu=inputUtils.inputFunctionSelect(3, StationFunction.GET_BACK.getMenu());
        if(StationFunction.GET_BACK.matchMenu(menu))
            return;
        if(StationFunction.ADD.matchMenu(menu))
            addStation();
        if(StationFunction.INQUIRY.matchMenu(menu))
            inquiryStationList();
    }

    private static void addStation(){
        printUtils.printAddStationGuide();
        try{
            Station newStation = new Station(inputUtils.inputNewStationName());
            if(stationRepository.isStationExist(newStation))
                throw new IllegalArgumentException();
            stationRepository.addStation(newStation);
            printUtils.printCompleteAddStation();
        }catch(IllegalArgumentException e){
            printUtils.duplicateStationError();
            addStation();
            return;
        }
    }

    private static void inquiryStationList() {
        printUtils.printStationsList();
        stationRepository.printStationsList();
    }

    private static void lineManagementMenu() {

    }

    private static void sectionManagementMenu() {

    }

    private static void subwayMapPrint() {

    }
}
