package subway.service;

import subway.constant.Function;
import subway.constant.Information;
import subway.constant.InitialData;
import subway.exception.InvalidInputException;
import subway.repository.StationRepository;

import java.util.Scanner;

public class StationService {

    private Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
        initStations();
    }

    private void initStations() {
        StationRepository.addStation(InitialData.stations);
    }

    public void run() {
        try {
            String selectedFunction = selectFunction();
            runSelectedFunction(selectedFunction);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private String selectFunction() {
        String line = getFunctionInput();
        Function.validate(line);
        return line;
    }

    private String getFunctionInput() {
        System.out.println(Information.STATION_INFO);
        return scanner.nextLine();
    }

    private void runSelectedFunction(String selectedFunction) {
        if (selectedFunction.equals(Function.ADD.getCode()))
            addNewStation();
        if (selectedFunction.equals(Function.DELETE.getCode()))
            deleteStation();
        if (selectedFunction.equals(Function.SHOW.getCode()))
            showStations();
    }

    private void addNewStation() {
        System.out.println(Information.ADD_STATION_INFO);
    }

    private void deleteStation() {
        System.out.println(Information.DELETE_STATION_INFO);
    }

    private void showStations() {
        System.out.println(Information.SHOW_STATION_INFO);
    }
}
