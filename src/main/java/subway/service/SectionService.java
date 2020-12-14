package subway.service;

import subway.controller.SectionMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.sectionviews.SectionInputView;
import subway.views.sectionviews.SectionOutputView;

import java.util.Scanner;

public class SectionService {
    private static final String NOT_EXIST_STATION_MESSAGE = "\n[ERROR] 존재하지 않는 역입니다.";
    private static final String ALREADY_CONTAINED_STATION_MESSAGE = "\n[ERROR] 이미 노선에 존재하는 역입니다.";
    private static final String NOT_EXIST_LINE_MESSAGE = "\n[ERROR] 존재하지 않는 노선입니다.";
    private static final String CANNOT_CONVERT_TO_INTEGER = "\n[ERROR] 순서는 숫자를 입력하셔야 합니다.";
    private static final String UNAVAILABLE_ORDER_INDEX_MESSAGE = "\n[ERROR] 상행 종점과 하행 종점 사이의 순서를 입력해야 합니다.";
    private static final int MINIMUM_AVAILABLE_ORDER_INDEX = 0;

    final Scanner scanner;

    public SectionService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void sectionAddService() {
        try {
            String lineName = SectionInputView.inputLine(scanner);
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
            sectionMenuController.mappingSectionMenu(scanner);
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
        Line lineToAdd = LineRepository.lines().stream().filter(line -> line.equals(new Line(lineName))).findFirst().get();
        if (lineToAdd.getStations().contains(new Station(stationName))) {
            throw new IllegalArgumentException(ALREADY_CONTAINED_STATION_MESSAGE);
        }
    }

    private int stringToInt(String sectionOrder) {
        try {
            return Integer.parseInt(sectionOrder);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(CANNOT_CONVERT_TO_INTEGER);
        }
    }

    private void isAvailableOrder(int sectionOrder, String lineName) {
        int maximum = LineRepository.lines().stream()
                          .filter(line -> line.getName().equals(lineName))
                          .findFirst()
                          .map(line -> line.getStations().size())
                          .get();
        if (sectionOrder < MINIMUM_AVAILABLE_ORDER_INDEX || sectionOrder > maximum) {
            throw new IllegalArgumentException(UNAVAILABLE_ORDER_INDEX_MESSAGE);
        }
    }

    private void sectionAdd(String lineName, String stationName, int sectionOrder) {
        Line lineToSectionAdd = LineRepository.lines().stream()
                                .filter(line -> line.getName().equals(lineName))
                                .findFirst()
                                .get();
        lineToSectionAdd.addLineStation(sectionOrder, new Station(stationName));
    }
}
