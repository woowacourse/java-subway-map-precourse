package subway.service.sectionservice;

import subway.domain.Line;
import subway.domain.Station;
import subway.views.InputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionDeleteService {
    private static final String NOT_EXIST_STATION_IN_LINE = "\n[ERROR] 해당 노선에 이 역이 등록되어 있지 않습니다.";
    private static final String CANNOT_DELETE_SECTION_WHEN_SIZE_IS_TWO_UNDER = "\n[ERROR] 구간에는 역이 2개 이상 있어야 합니다.";
    private static final int MINIMUM_AVAILABLE_DELETE_SECTION_SIZE = 2;
    private static final SectionDeleteService sectionDeleteService = new SectionDeleteService();

    private SectionDeleteService() {
    }

    public static SectionDeleteService getInstance() {
        return sectionDeleteService;
    }

    public void sectionDeleteService(Scanner scanner) {
        try {
            String lineName = makeLineNameToDeleteSection(scanner);
            String stationName = makeStationNameToDeleteSection(scanner, lineName);
            deleteSectionFromRepository(lineName, stationName);
        } catch (IllegalArgumentException e) {
            SectionService.goToMenu(e, scanner);
        }
    }

    private String makeLineNameToDeleteSection(Scanner scanner) {
        SectionOutputView.printLineToDeleteSectionMessage();
        String lineName = InputView.userInput(scanner);
        SectionService.isExistLine(lineName);
        return lineName;
    }

    private String makeStationNameToDeleteSection(Scanner scanner, String lineName) {
        SectionOutputView.printStationToDeleteSectionMessage();
        String stationName = InputView.userInput(scanner);
        isExistStationInLine(lineName, stationName);
        return stationName;
    }

    private void isExistStationInLine(String lineName, String stationName) {
        Line lineToDelete = SectionService.findLineByLineName(lineName);
        if (!lineToDelete.getStations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_IN_LINE);
        }
    }

    private void deleteSectionFromRepository(String lineName, String stationName) {
        isBiggerSizeThanTwo(lineName);
        sectionDelete(lineName, stationName);
        SectionOutputView.printDeleteSuccess();
    }

    private void sectionDelete(String lineName, String stationName) {
        Line lineToDelete = SectionService.findLineByLineName(lineName);
        lineToDelete.deleteLineStation(new Station(stationName));
    }

    private void isBiggerSizeThanTwo(String lineName) {
        if (SectionService.getLineStationSize(lineName) <= MINIMUM_AVAILABLE_DELETE_SECTION_SIZE) {
            throw new IllegalArgumentException(CANNOT_DELETE_SECTION_WHEN_SIZE_IS_TWO_UNDER);
        }
    }
}
