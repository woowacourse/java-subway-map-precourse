package subway.controller;

import subway.view.LinePage;
import subway.view.StationPage;
import utils.ErrorUtils;

import java.util.Scanner;

public class LineController {
    private static final String ADD_Line = "1";
    private static final String DELETE_Line = "2";
    private static final String SELECT_Line = "3";
    private static final String BACK = "B";

    public static void startStationPage(Scanner scanner){
        LinePage.printLineManagementPage();
        forkPath(chooseItem(scanner), scanner);
    }

    public static void forkPath(String item, Scanner scanner){
        if(ADD_Line.equals(item)){
            startInsertLine(scanner);
        }
        if(DELETE_Line.equals(item)){
            startDeleteLine(scanner);
        }
        if(SELECT_Line.equals(item)){
            startSelectLine(scanner);
        }
        if(BACK.equals(item)){
            MainController.startMainPage(scanner);
        }
    }

    public static String chooseItem(Scanner scanner){
        String item = input(scanner);
        if(!isValidItem(item)){
            ErrorUtils.printError("잘못된 입력입니다.");
            startStationPage(scanner);
        }
        return item;
    }

    public static String input(Scanner scanner){
        return scanner.next();
    }

    public static boolean isValidItem(String item){
        if(ADD_Line.equals(item) || DELETE_Line.equals(item) ||
                SELECT_Line.equals(item) || BACK.equals(item)){
            return true;
        }
        return false;
    }




}
