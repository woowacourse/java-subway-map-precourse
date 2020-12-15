package subway.Exception;

import subway.Controller.StationController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputView;

public class StationExceptionHandler {

    private static final int MIN_LENGTH = 2;

    private static void goBack() {
        StationController.run();
    }

    private static void printErrorAndGoBack(String error) {
        OutputView.printError(error);
        goBack();
    }

    public static void unselectable(String selection, String[] pattern) {
        try {
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void stationContainedInLine(String name) {
        try {
            if (LineRepository.containsStation(name)) {
                throw new CustomException("노선에 등록된 역은 삭제할 수 없습니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void duplicatedStation(String name) {
        try {
            if (StationRepository.contains(name)) {
                throw new CustomException("중복된 지하철 역 이름은 등록될 수 없습니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void stationNameShorterThanTwo(String name) {
        try {
            if (name.length() < MIN_LENGTH) {
                throw new CustomException("지하철 역 이름은 2글자 이상이어야 합니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void stationShouldNotBeInLineForAddingToSection(String lineName,
        String stationName) {
        try {
            isStationInLine(lineName, stationName);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    private static void isStationInLine(String lineName, String stationName) {
        if (LineRepository.lineContainsStation(lineName, stationName)) {
            throw new CustomException("이미 구간에 있는 역은 추가할 수 없습니다.");
        }
    }
}
