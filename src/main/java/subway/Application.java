package subway;

import subway.domain.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Init.initialize();
        startProgram(scanner);
    }

    public static void startProgram(Scanner kbd) {
        View.showMainMenu();
        String mainInput = InputView.inputFunction(kbd, Constants.MAIN_FUNCTIONS);
        goSubMenu(mainInput, kbd);
    }

    public static void goSubMenu(String input, Scanner kbd) {
        System.out.println();
        if (input.equals(Constants.STATION_MENU))
            StationManage.manageStation(kbd);
        if (input.equals(Constants.LINE_MENU))
            LineManage.manageLine(kbd);
        if (input.equals(Constants.SECTION_MENU))
            SectionManage.manageSection(kbd);
        if (input.equals(Constants.PRINT_LINES))
            View.displayAllLines(kbd);
        if (input.equalsIgnoreCase(Constants.FINISH_PROGRAM))
            finishProgram();
    }

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }
}