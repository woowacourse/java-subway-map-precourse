package subway.controller;

import subway.exception.AttemptToDeleteDependentObjectException;
import subway.menuType.FunctionType;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.DTO;
import subway.view.OutputView;
import subway.view.menuView.StationView;

import java.util.List;
import java.util.stream.Collectors;

public class StationManagement {
    private static final String ERROR_CANNOT_REMOVE = "노선에 등록된 역은 삭제할 수 없습니다.";

    private static StationView stationView = StationView.getInstance();
    private static FunctionType menu;

    public static void run() {
        do {
            try {
                stationView.printMenu();
                menu = stationView.getFunctionSelection();
                runSelectedMenuFunction();
            } catch (RuntimeException e) {
                OutputView.printErrorMessage(e);
            }
        } while (!menu.equals(FunctionType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(FunctionType.CREATE)) {
            registerStation();
        }
        if (menu.equals(FunctionType.DELETE)) {
            deleteStation();
        }
        if (menu.equals(FunctionType.READ)) {
            printAllStation();
        }
    }

    private static void registerStation() {
        Station station = new Station(stationView.getNameToCreate());
        StationRepository.addStation(station);
        stationView.printCreateDone();
    }

    private static void deleteStation() {
        String name = stationView.getNameToDelete();
        throwExceptionIfItisInLines(name);

        StationRepository.deleteStation(name);
        stationView.printDeleteDone();
    }

    private static boolean throwExceptionIfItisInLines(String name) {
        Station key = new Station(name);
        boolean exist = LineRepository.lines().stream()
                .anyMatch(line -> line.contains(key));

        if (exist) {
            throw new AttemptToDeleteDependentObjectException(ERROR_CANNOT_REMOVE);
        }

        return true;
    }

    private static void printAllStation() {
        List<DTO> stationNames = StationRepository.stations().stream()
                .map(Station::toDTO)
                .collect(Collectors.toList());

        stationView.printAll(stationNames);
    }

}
