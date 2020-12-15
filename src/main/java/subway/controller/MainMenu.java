package subway.controller;

import subway.domain.LineManager;
import subway.domain.StationManager;
import subway.view.PrintInfo;
import subway.view.Error;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainMenu extends Menu{
    private static final String MENU_FOUR = "4";
    private static final String MENU_QUIT = "Q";
    private final StationMenu stationMenu;
    private final LineMenu lineMenu;
    private final SectionMenu sectionMenu;

    public MainMenu(Scanner scanner) {
        super(scanner);
        stationMenu = new StationMenu(scanner);
        lineMenu = new LineMenu(scanner);
        sectionMenu = new SectionMenu(scanner);
    }

    public void initPrimaryStation(String[] stations) {
        Arrays.asList(stations).forEach(StationManager::addStation);
    }

    public void initPrimaryLine(String lineName, String[] stations) {
        LineManager.initLine(lineName, stations);
    }

    @Override
    protected void info() {
        PrintInfo.mainMenu();
    }

    @Override
    protected boolean managing(String choice) {
        if (PRIMARY_FUNCTIONS.contains(choice)) {
            executeFunction(choice);
            return true;
        }
        if (choice.equals(MENU_FOUR)) {
            printSubwayMap();
            return true;
        }
        if (choice.equals(MENU_QUIT)) {
            return false;
        }
        Error.noFunction();
        return true;
    }

    @Override
    protected boolean functionOne() {
        stationMenu.run();
        return true;
    }

    @Override
    protected boolean functionTwo() {
        lineMenu.run();
        return true;
    }

    @Override
    protected boolean functionThree() {
        sectionMenu.run();
        return true;
    }

    private void printSubwayMap() {
        PrintInfo.subwayMapTitle();
        LineManager.allLines().forEach(line -> {
            PrintInfo.subwayMapLine(line.getName());
            PrintInfo.printList(line.getSubStations().stream().map(station -> station.getName()).collect(Collectors.toList()));
        });
    }
}
