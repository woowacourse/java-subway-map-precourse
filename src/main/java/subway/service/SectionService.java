package subway.service;

import subway.domain.LineRepository;
import subway.domain.LineStationRepository;
import subway.domain.MenuType;
import subway.domain.StationRepository;
import subway.utils.InputValidation;

import java.util.Scanner;

import static subway.view.InputView.*;
import static subway.view.OutputView.printAddSectionSuccessMessage;
import static subway.view.OutputView.printDeleteSectionSuccessMessage;

public class SectionService extends InputValidation {

    public void selectSectionManagementMenu(Scanner scanner, String menu, LineStationRepository lineStation) {
        if (menu.equals(MenuType.SECTION_ADD.getKey())) {
            addSection(scanner, lineStation);
        }
        if (menu.equals(MenuType.SECTION_DELETE.getKey())) {
            deleteSection(scanner, lineStation);
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
        validateLineNameIsContains(lineName);
        validateStationNameIsContains(stationName);
        //3. 입력값이 숫자인지 검증한다.
        //4. 입력값이 노선의 길이보다 이하의 값인지 검증한다.
        lineStation.addStationInLine(LineRepository.findLine(lineName).get(),
                StationRepository.findStation(stationName).get(),
                Integer.parseInt(position));
        printAddSectionSuccessMessage();
    }

    private void deleteSection(Scanner scanner, LineStationRepository lineStation) {
        inputLineNameToDeleteSectionRequestMessage();
        String lineName = scanner.nextLine();
        inputStationNameToDeleteSectionRequestMessage();
        String stationName = scanner.nextLine();
        //validation
        validateLineNameIsContains(lineName);
        //2. 입력한 노선에 역 개수가 2개 이상인지 검증한다.
        validateStationNameIsContains(stationName);
        lineStation.deleteStationInLineByName(LineRepository.findLine(lineName).get(), stationName);
        printDeleteSectionSuccessMessage();
    }
}