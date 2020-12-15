package subway.managers;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exceptions.SubwayException;
import subway.exceptions.Validation;
import subway.views.SystemMessages;
import subway.views.SystemOutput;
import subway.views.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StationManager {
    private static Validation validation = new Validation();

    public static void runStationManager(Scanner scanner, UserInput userInput) {
        SystemOutput.printStationMessage();
        String input = userInput.getInput();
        try {
            validation.stationLineOptionValidation(input);
        } catch (SubwayException e) {
            runStationManager(scanner, userInput);
        }
        if (input.equals("1")) {
            addStation(userInput);
        }
        if (input.equals("2")) {
            deleteStation(scanner, userInput);
        }
        if (input.equals("3")) {
            showStationList();
        }
        if (input.equals("B")) {
            SubwayManager.runManager(scanner);
        }
    }

    static void addStation(UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.ADD_STATION_MESSAGE);
        String name = userInput.getInput();
        try {
            validation.stationNameValidation(name);
            validation.stationDuplication(name);
        } catch (SubwayException e) {
            addStation(userInput);
        }
        Station station = new Station(name);
        StationRepository.addStation(station);
        SystemOutput.printInfo(SystemMessages.ADD_STATION_COMPLETE_MESSAGE);
    }

    static void deleteStation(Scanner scanner, UserInput userInput) {
        SystemOutput.printMessage(SystemMessages.DEL_STATION_MESSAGE);
        String name = userInput.getInput();
        try {
            validation.isExistStation(name);
            StationRepository.deleteStation(name);
        } catch (SubwayException e) {
            SubwayManager.runManager(scanner);
        }
        StationRepository.deleteStation(name);
        SystemOutput.printInfo(SystemMessages.DEL_STATION_COMPLETE_MESSAGE);
    }

    static void showStationList() {
        SystemOutput.printMessage(SystemMessages.STATION_LIST_MESSAGE);
        List<Station> stations = StationRepository.getStations();
        List<String> names = new ArrayList();
        for (Station station : stations) {
            names.add(station.getName());
        }
        String[] stationList = new String[names.size()];
        SystemOutput.printList(names.toArray(stationList));
    }
}
