package subway.view;

import subway.Constant;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Scanner;

public class StationController {
    private static final String ADD_STATION_SUCCESS = "지하철 역이 등록되었습니다.\n";
    private static final String DELETE_STATION_SUCCESS = "지하철 역이 삭제되었습니다.\n";
    Scanner scanner;
    StationRepository stationRepository = new StationRepository();

    public StationController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printSelection() {
        System.out.println(Constant.STATION_ANNOUNCEMENT);
        String command = scanner.next();
        if (command.equals(Constant.FIRST_COMMAND)) {
            addStation();
        } else if (command.equals(Constant.SECOND_COMMAND)) {
            deleteStation();
        } else if (command.equals(Constant.THIRD_COMMAND)) {
            readStations();
        } else if (command.equals(Constant.BACK_COMMAND)) {
            return;
        }
    }

    void addStation() {
        System.out.println(String.join(" 역 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String stationName = scanner.next();
        try {
            stationRepository.addStation(new Station(stationName));
            System.out.println(String.join(" ", Constant.INFO_PREFIX, ADD_STATION_SUCCESS));
        } catch (IllegalArgumentException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
        } catch (IllegalStateException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NAME_LENGTH_SHORT));
        }
    }

    void deleteStation() {
        System.out.println(String.join(" 역 ", Constant.DELETE_PREFIX, Constant.NAME_POSTFIX));
        String stationName = scanner.next();
        boolean deleteFlag = stationRepository.deleteStation(stationName);
        if (deleteFlag) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, DELETE_STATION_SUCCESS));
            return;
        }
        System.out.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
    }

    void readStations() {
        for (int i = 0; i < stationRepository.stations.size(); i++) {
            System.out.println(String.join(" ", Constant.INFO_PREFIX, stationRepository.stations.get(i).getName()));
        }
    }
}
