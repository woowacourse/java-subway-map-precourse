package subway.service;

import subway.domain.*;

import java.util.Scanner;

import static subway.view.InputView.*;
import static subway.view.OutputView.printAddLineStationSuccessMessage;

public class LineStationService {

    public void selectLineStationManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if(menu.equals(MenuType.LINE_STATION_ADD.getKey())) {
            addLineStation(scanner, lineStation);
        }
        if(menu.equals(MenuType.LINE_STATION_DELETE.getKey())) {

        }
        if(menu.equals(MenuType.LINE_STATION_SEARCH.getKey())) {

        }
        if(menu.equals(MenuType.BACK.getKey())) {
            return;
        }
    }

    private void addLineStation(Scanner scanner, LineStationRepository lineStation) {
        inputAddLineNameRequestMessage();
        String lineName = scanner.nextLine();
        inputAddStartStationNameRequestMessage();
        String startStationName = scanner.nextLine();
        inputAddEndStationNameRequestMessage();
        String endStationName = scanner.nextLine();
        //validation
        //1. 노선 이름이 2글자 이상인지 검증한다
        //2. 중복된 노선 이름이 존재하는지 검증한다
        //3. 입력한 역 이름이 존재하는지 검증한다(상행)
        //4. 입력한 역 이름이 존재하는지 검증한다(하행)
        Line line = new Line(lineName);
        LineRepository.addLine(line);
        lineStation.addLineStation(line, StationRepository.findStation(startStationName).get());
        lineStation.addLineStation(line, StationRepository.findStation(endStationName).get());
        printAddLineStationSuccessMessage();
    }
}