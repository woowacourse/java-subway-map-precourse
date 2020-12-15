package subway.service;

import subway.controller.SectionMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.sectionviews.SectionInputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Optional;
import java.util.Scanner;

public class SectionService {
    private static final String NOT_EXIST_STATION_MESSAGE = "\n[ERROR] 존재하지 않는 역입니다.";
    private static final String ALREADY_CONTAINED_STATION_MESSAGE = "\n[ERROR] 이미 노선에 존재하는 역입니다.";
    private static final String NOT_EXIST_LINE_MESSAGE = "\n[ERROR] 존재하지 않는 노선입니다.";
    private static final String CANNOT_CONVERT_TO_INTEGER = "\n[ERROR] 순서는 숫자를 입력하셔야 합니다.";
    private static final String UNAVAILABLE_ORDER_INDEX_MESSAGE = "\n[ERROR] 상행 종점과 하행 종점 사이의 순서를 입력해야 합니다.";
    private static final String NOT_EXIST_STATION_IN_LINE = "\n[ERROR] 해당 노선에 이 역이 등록되어 있지 않습니다.";
    private static final String CANNOT_DELETE_SECTION_WHEN_SIZE_IS_TWO_UNDER = "\n[ERROR] 구간에는 역이 2개 이상 있어야 합니다.";
    private static final int MINIMUM_AVAILABLE_ORDER_INDEX = 0;
    private static final int MINIMUM_AVAILABLE_DELETE_SECTION_SIZE = 2;

    final Scanner scanner;

    public SectionService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void sectionAddService() {
        try {
            String lineName = SectionInputView.inputLineToAdd(scanner);
            isExistLine(lineName);
            String stationName = SectionInputView.inputStation(scanner);
            isExistStation(stationName);
            isAlreadyContainInLine(lineName, stationName);
            int sectionOrder = stringToInt(SectionInputView.inputOrder(scanner));
            isAvailableOrder(sectionOrder, lineName);
            sectionAdd(lineName, stationName, sectionOrder);
            SectionOutputView.printAddSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            SectionMenuController sectionMenuController = SectionMenuController.getInstance();
            sectionMenuController.mappingMenu(scanner);
        }
    }

    private void isExistLine(String lineName) {
        if (!LineRepository.lines().contains(new Line(lineName))) {
            throw new IllegalArgumentException(NOT_EXIST_LINE_MESSAGE);
        }
    }

    private void isExistStation(String stationName) {
        if (!StationRepository.stations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_MESSAGE);
        }
    }

    private void isAlreadyContainInLine(String lineName, String stationName) {
        Line lineToAdd = findLineByLineName(lineName);
        if (lineToAdd.getStations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(ALREADY_CONTAINED_STATION_MESSAGE);
        }
    }

    private Line findLineByLineName(String lineName) {
        return LineRepository.lines().stream()
            .filter(line -> line.equals(new Line(lineName)))
            .findFirst().get();
    }

    private int stringToInt(String sectionOrder) {
        try {
            return Integer.parseInt(sectionOrder);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_TO_INTEGER);
        }
    }

    private void isAvailableOrder(int sectionOrder, String lineName) {
        int maximumOrder = getLineStationSize(lineName);
        if (sectionOrder < MINIMUM_AVAILABLE_ORDER_INDEX || sectionOrder > maximumOrder + 1) {
            throw new IllegalArgumentException(UNAVAILABLE_ORDER_INDEX_MESSAGE);
        }
    }

    private Optional<Line> findLineByName(String lineName) {
        return LineRepository.lines().stream()
            .filter(line -> line.getName().equals(lineName))
            .findFirst();
    }

    private int getLineStationSize(String lineName) {
        return findLineByName(lineName)
            .map(line -> line.getStations().size())
            .get();
    }

    private void sectionAdd(String lineName, String stationName, int sectionOrder) {
        Line lineToSectionAdd = findLineByName(lineName).get();
        lineToSectionAdd.addLineStation(sectionOrder-1, new Station(stationName));
    }

    public void sectionDeleteService() {
        try {
            String lineName = SectionInputView.inputLineToDelete(scanner);
            isExistLine(lineName);
            String stationName = SectionInputView.inputStation(scanner);
            isExistLine(lineName, stationName);
            isBiggerSizeThanTwo(lineName);
            sectionDelete(lineName, stationName);
            SectionOutputView.printDeleteSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            SectionMenuController sectionMenuController = SectionMenuController.getInstance();
            sectionMenuController.mappingMenu(scanner);
        }
    }

    private void isExistLine(String lineName, String stationName) {
        Line lineToDelete = findLineByLineName(lineName);
        if (!lineToDelete.getStations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(NOT_EXIST_STATION_IN_LINE);
        }
    }

    private void sectionDelete(String lineName, String stationName) {
        Line lineToDelete = findLineByLineName(lineName);
        lineToDelete.deleteLineStation(new Station(stationName));
    }

    private void isBiggerSizeThanTwo(String lineName) {
        if (getLineStationSize(lineName) <= MINIMUM_AVAILABLE_DELETE_SECTION_SIZE) {
            throw new IllegalArgumentException(CANNOT_DELETE_SECTION_WHEN_SIZE_IS_TWO_UNDER);
        }
    }
}
