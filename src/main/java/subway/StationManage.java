package subway;

import static log.ErrorCase.ALREADY_EXIST_ERROR;
import static log.ErrorCase.NAME_LENGTH_ERROR;
import static log.ErrorCase.NO_SUCH_NAME_ERROR;
import static log.Logger.displayInputScreen;
import static log.Logger.displayStationManageScreen;
import static log.Logger.errorPrint;
import static log.Logger.guidePrint;
import static log.Logger.infoPrint;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.deleteStation;
import static subway.domain.StationRepository.hasStation;
import static subway.domain.StationRepository.stations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.Station;

public class StationManage {

    static final String ADD_STATION = "1";
    static final String DELETE_STATION = "2";
    static final String ALL_STATIONS = "3";
    static final String BACK_SCREEN = "B";
    static final int MIN_STATION_NAME_LENGTH = 2;

    static public void stationManage(Scanner scanner) {
        boolean exitFlag = false;
        while (!exitFlag) {
            displayStationManageScreen();
            exitFlag = isExit(scanner);
        }
    }

    private static boolean isExit(Scanner scanner) {
        String input = displayInputScreen(scanner, new ArrayList<>(Arrays.asList(
            ADD_STATION, DELETE_STATION, ALL_STATIONS, BACK_SCREEN)));
        if (input.equals(BACK_SCREEN)) {
            return true;
        }
        if (input.equals(ADD_STATION)) {
            return addStationControl(scanner);
        }
        if (input.equals(DELETE_STATION)) {
            return deleteStationControl(scanner);
        }
        if (input.equals(ALL_STATIONS)) {
            return allStationsContol();
        }
        return false;
    }

    private static boolean addStationControl(Scanner scanner) {
        guidePrint("등록할 역 이름을 입력하세요. \n");
        String stationName = scanner.next();
        if (!stationNameLengthValidate(stationName)) {
            errorPrint(NAME_LENGTH_ERROR);
            return false;
        }
        if (stationExists(stationName)) {
            errorPrint(ALREADY_EXIST_ERROR);
            return false;
        }
        addStation(new Station(stationName));
        infoPrint("지하철 역이 등록되었습니다. \n");
        return true;
    }

    private static boolean deleteStationControl(Scanner scanner) {
        guidePrint("삭제할 역 이름을 입력하세요. \n");
        String stationName = scanner.next();
        if (!stationExists(stationName)) {
            errorPrint(NO_SUCH_NAME_ERROR);
            return false;
        }
        deleteStation(stationName);
        infoPrint("지하철 역이 삭제되었습니다. \n");
        return true;
    }

    private static boolean allStationsContol() {
        guidePrint("역 목록\n");
        List<Station> allStations = stations();
        for (Station station : allStations) {
            station.print();
        }
        return true;
    }

    private static boolean stationNameLengthValidate(String stationName) {
        return stationName.length() >= MIN_STATION_NAME_LENGTH;
    }

    private static boolean stationExists(String stationName) {
        return hasStation(stationName);
    }
}
