package subway.controller;

import subway.exception.AttemptToDeleteDependentObjectException;
import subway.exception.NoneObjectException;
import subway.menuType.ManagementMenuType;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.DTO;
import subway.view.menuView.StationView;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StationManagement {
    private static final String ERROR_CANNOT_REMOVE = "노선에 등록된 역은 삭제할 수 없습니다.";
    private static final String ERROR_NO_STATIONS = "등록된 역이 없습니다.";

    private static StationView stationView = StationView.getInstance();
    private static ManagementMenuType menu;
    private static HashMap<ManagementMenuType, matchedFunction> mapToFunction;

    static {
        StationManagement.mapToFunction = new HashMap<>();
        mapToFunction.put(ManagementMenuType.CREATE, StationManagement::registerStation);
        mapToFunction.put(ManagementMenuType.DELETE, StationManagement::deleteStation);
        mapToFunction.put(ManagementMenuType.READ, StationManagement::printAllStation);
        mapToFunction.put(ManagementMenuType.ESCAPE, () -> {});
    }

    public static void run() {
        do {
            try {
                stationView.printMenu();
                menu = stationView.getMenuSelection();
                mapToFunction.get(menu).run();
            } catch (RuntimeException e) {
                stationView.printErrorMessage(e);
            }
        } while (!menu.equals(ManagementMenuType.ESCAPE));
    }

    private static void registerStation() {
        Station station = new Station(stationView.getNameToCreate());
        StationRepository.addStation(station);
        stationView.printCreateDone();
    }

    private static void deleteStation() {
        String name = stationView.getNameToDelete();

        if (StationRepository.isEmpty()) {
            throw new NoneObjectException(ERROR_NO_STATIONS);
        }
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
