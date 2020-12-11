package subway.service;

import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.domain.StationRepository;

import java.util.Scanner;

import static subway.view.InputView.*;
import static subway.view.OutputView.printAddSectionSuccessMessage;

public class SectionService {

    public void selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if(menu.equals(MenuType.SECTION_ADD.getKey())) {
            addSection(scanner, lineStation);
        }
        if(menu.equals(MenuType.SECTION_DELETE.getKey())) {

        }
        if(menu.equals(MenuType.BACK.getKey())) {
            return;
        }
    }

    private void addSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToAddSectionRequestMessage();
        String lineName = scanner.nextLine();
        inputStationNameToAddSectionRequestMessage();
        String stationName = scanner.nextLine();
        inputPositionToAddSectionRequestMessage();
        String position = scanner.nextLine();
        //validation
        //1. 입력한 노선 이름이 존재하는지 검증한다.
        //2. 입력한 역 이름이 존재하는지 검증한다.
        //3. 입력값이 숫자인지 검증한다.
        //4. 입력값이 노선의 길이보다 이하의 값인지 검증한다.
        lineStation.addStationInLine(LineRepository.findLine(lineName).get(),
                StationRepository.findStation(stationName).get(),
                Integer.parseInt(position));
        printAddSectionSuccessMessage();
    }
}