package subway.service;

import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;

import java.util.Scanner;

import static subway.view.InputView.inputAddStationNameRequestMessage;
import static subway.view.OutputView.printAddStationSuccessMessage;

public class StationService {

    public void selectStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if(menu.equals(MenuType.STATION_ADD.getKey())) {
            addStation(scanner);
        }
        if(menu.equals(MenuType.STATION_DELETE.getKey())) {
            deleteStation(scanner);
        }
        if(menu.equals(MenuType.STATION_SEARCH.getKey())) {
            printStations();
        }
        if(menu.equals(MenuType.BACK.getKey())) {
            return;
        }
    }

    private void addStation(Scanner scanner) {
        inputAddStationNameRequestMessage();
        String name = scanner.nextLine();
        //validation
        //1.이름의 길이가 2이상인지 검증한다
        //2.중복된 역 이름이 존재하는지 검증한다
        StationRepository.addStation(new Station(name));
        printAddStationSuccessMessage();
    }

    private void deleteStation(Scanner scanner) {
        InputView.inputDeleteStationNameRequestMessage();
        String name = scanner.nextLine();
        //validation
        //1.입력한 역 이름이 존재하는지 검증한다
        StationRepository.deleteStation(name);
    }

    private void printStations() {
        StationRepository.printStations();
    }
}