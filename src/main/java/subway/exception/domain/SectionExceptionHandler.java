package subway.exception.domain;

import subway.Controller.domain.SectionController;
import subway.domain.LineRepository;
import subway.exception.CustomException;
import subway.view.OutputView;

public class SectionExceptionHandler {

    private static final int MIN_LENGTH = 2;

    private static void goBack() {
        SectionController.run();
    }

    private static void printErrorAndGoBack(String error) {
        OutputView.printError(error);
        goBack();
    }

    public static void positiveInt(String string) {
        try {
            isNotInt(string);
            isNotPositive(string);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    private static void isNotInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throw new CustomException("숫자형식이 아닙니다.");
        }
    }

    private static void isNotPositive(String string) {
        if (Integer.parseInt(string) <= 0) {
            throw new CustomException("0보다 큰 수이어야 합니다.");
        }
    }

    public static void notLineContained(String lineName) {
        try {
            isNotLineContained(lineName);
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    private static void isNotLineContained(String lineName) {
        if (!LineRepository.contains(lineName)) {
            throw new CustomException("등록되지 않은 노선에 구간을 추가할 수 없습니다.");
        }
    }

    public static void noLine(String lineName) {
        try {
            if (!LineRepository.contains(lineName)) {
                throw new CustomException("없는 노선은 삭제할 수 없습니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }

    }

    public static void noStationInLine(String lineName, String stationName) {
        try {
            if (!LineRepository.lineContainsStation(lineName, stationName)) {
                throw new CustomException("노선에 없는 역은 삭제할 수 없습니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void stationInLineLessThanMinLength(String lineName) {
        try {
            if (LineRepository.getSectionLength(lineName) <= MIN_LENGTH) {
                throw new CustomException("노선에 포함된 역이 두 개 이하일 때는 역을 제거할 수 없습니다.");
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

    public static void lineOverflow(String line, String order) {
        try {
            overflow(line, Integer.parseInt(order));
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    private static void overflow(String line, int order) {
        int max = LineRepository.getSectionLength(line) - 1;
        if (order > max) {
            throw new CustomException("순서는 " + max + "이하여야 합니다. (입력값: " + order + ")");
        }
    }
}
