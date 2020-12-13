package subway.controller;

import subway.view.MainPage;
import subway.view.StationPage;
import utils.ErrorUtils;

import java.util.Scanner;

public class MainController {
    private static final String STATION_MANAGEMENT = "1";
    private static final String LINE_MANAGEMENT = "2";
    private static final String ROUTE_MANAGEMENT = "3";
    private static final String ROUTE_MAP = "4";
    private static final String QUIT = "Q";


    public static void startMainPage(Scanner scanner){
        showMainPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void showMainPage(){
        MainPage.printMainPage();
    }

    public static void forkPath(String item, Scanner scanner){
        if(STATION_MANAGEMENT.equals(item)){
            StationController.startStationPage(scanner);
        }
        if(LINE_MANAGEMENT.equals(item)){

        }
        if(ROUTE_MANAGEMENT.equals(item)){

        }
        if(ROUTE_MAP.equals(item)){

        }
    }

    public static String chooseItem(Scanner scanner){
        String item = input(scanner);
        if(!isValidItem(item)){
            ErrorUtils.printError("잘못된 입력입니다.");
            startMainPage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner){
        return scanner.next();
    }

    public static boolean isValidItem(String input){
        if(STATION_MANAGEMENT.equals(input) || LINE_MANAGEMENT.equals(input) ||
           ROUTE_MANAGEMENT.equals(input) || ROUTE_MAP.equals(input) || QUIT.equalsIgnoreCase(input)){
            return true;
        }
        return false;
    }
}
