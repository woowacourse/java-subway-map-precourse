package subway;

import subway.controller.*;
import subway.init.InitData;
import subway.ui.*;

import java.util.Scanner;

public class Application {
    private static final String MAIN_MENU_QUIT_VALUE = "Q";
    private static final String MAIN_MENU_SELECT_STATION = "1";
    private static final String MAIN_MENU_SELECT_LINE = "2";
    private static final String MAIN_MENU_SELECT_SECTION = "3";
    private static final String MAIN_MENU_SELECT_MAP = "4";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InitData.startInitWork();
        while(true) {
            MainUI.printScreen();
            String select = MainController.selectMenu(scanner);
            if(select.equals(MAIN_MENU_QUIT_VALUE)) {
                MainUI.printQuit();
                break;
            }
            executeMenu(select, scanner);
        }
    }

    private static void executeMenu(String select, Scanner scanner) {
        if(select.equals(MAIN_MENU_SELECT_STATION)) {
            StationUI.printScreen();
            StationController.selectMenu(scanner);
        }
        if(select.equals(MAIN_MENU_SELECT_LINE)) {
            LineUI.printScreen();
            LineController.selectMenu(scanner);
        }
        if(select.equals(MAIN_MENU_SELECT_SECTION)) {
            SectionUI.printScreen();
            SectionController.selectMenu(scanner);
        }
        if(select.equals(MAIN_MENU_SELECT_MAP)) {
            MapUI.printScreen();
            MapController.selectMenu(scanner);
        }
    }
}
