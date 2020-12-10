package subway;

import com.sun.tools.javac.Main;
import java.util.Scanner;
import subway.utils.InputUtils;
import subway.utils.PrintUtils;

public class Application {

    enum MainFunction {
        STATION_MANAGEMENT('1'), LINE_MANAGEMENT('2'), SECTION_MANAGEMENT('3'), SUBWAY_MAP(
            '4'), QUIT('Q');

        final private char menu;

        private MainFunction(char menu){this.menu=menu;}

        public char getMenu(){return menu;}

    }

    private static PrintUtils printUtils;
    private static InputUtils inputUtils;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        printUtils = new PrintUtils();
        inputUtils = new InputUtils();
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

    }

    private static void lineManagementMenu() {

    }

    private static void sectionManagementMenu() {

    }

    private static void subwayMapPrint() {

    }
}
