package subway.service.sectionservice;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.InputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionAddService {
    private static final String NOT_EXIST_STATION_MESSAGE = "\n[ERROR] 존재하지 않는 역입니다.";
    private static final String ALREADY_CONTAINED_STATION_MESSAGE = "\n[ERROR] 이미 노선에 존재하는 역입니다.";
    private static final String CANNOT_CONVERT_TO_INTEGER = "\n[ERROR] 순서는 숫자를 입력하셔야 합니다.";
    private static final String UNAVAILABLE_ORDER_INDEX_MESSAGE = "\n[ERROR] 상행 종점과 하행 종점 사이의 순서를 입력해야 합니다.";
    private static final int MINIMUM_AVAILABLE_ORDER_INDEX = 0;
    private static final SectionAddService sectionAddService = new SectionAddService();

    private SectionAddService() {
    }

    public static SectionAddService getInstance() {
        return sectionAddService;
    }

    public void sectionAddService(Scanner scanner) {
        try {
            String lineName = makeLineNameToAddSection(scanner);
            String stationName = makeStationNameToAddSection(scanner);
            isAlreadyContainInLine(lineName, stationName);
            int sectionOrder = makeOrderToAddSection(lineName, scanner);
            sectionAdd(lineName, stationName, sectionOrder);
        } catch (IllegalArgumentException e) {
            SectionService.goToMenu(e, scanner);
        }
    }

    private String makeLineNameToAddSection(Scanner scanner) {
        SectionOutputView.printLineToAddSectionMessage();
        String lineName = InputView.userInput(scanner);
        SectionService.isExistLine(lineName);
        return lineName;
    }

    private String makeStationNameToAddSection(Scanner scanner) {
        SectionOutputView.printStationToAddSectionMessage();
        String stationName = InputView.userInput(scanner);
        isExistStation(stationName);
        return stationName;
    }

    private void isExistStation(String stationName) {
        if (!StationRepository.stations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_MESSAGE);
        }
    }

    private void isAlreadyContainInLine(String lineName, String stationName) {
        Line lineToAdd = SectionService.findLineByLineName(lineName);
        if (lineToAdd.getStations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(ALREADY_CONTAINED_STATION_MESSAGE);
        }
    }

    private int makeOrderToAddSection(String lineName, Scanner scanner) {
        SectionOutputView.printOrderToAddSectionMessage();
        int sectionOrder = stringToInt(InputView.userInput(scanner));
        isAvailableOrder(sectionOrder, lineName);
        return sectionOrder;
    }

    private int stringToInt(String sectionOrder) {
        try {
            return Integer.parseInt(sectionOrder);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_TO_INTEGER);
        }
    }

    private void isAvailableOrder(int sectionOrder, String lineName) {
        int maximumOrder = SectionService.getLineStationSize(lineName);
        if (sectionOrder < MINIMUM_AVAILABLE_ORDER_INDEX || sectionOrder > maximumOrder + 1) {
            throw new IllegalArgumentException(UNAVAILABLE_ORDER_INDEX_MESSAGE);
        }
    }

    private void sectionAdd(String lineName, String stationName, int sectionOrder) {
        Line lineToSectionAdd = SectionService.findLineByName(lineName).get();
        lineToSectionAdd.addLineStation(sectionOrder-1, new Station(stationName));
        SectionOutputView.printAddSuccess();
    }
}
