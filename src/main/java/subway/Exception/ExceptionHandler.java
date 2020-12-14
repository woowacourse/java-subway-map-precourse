package subway.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.LineController;
import subway.Controller.MainController;
import subway.Controller.SectionController;
import subway.Controller.StationController;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.view.OutputView;

public class ExceptionHandler {

    public static void unselectableMain(String selection, String[] pattern) {
        try {
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            MainController.select();
        }
    }

    public static void unselectableStation(String selection, String[] pattern) {
        try {
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            StationController.select();
        }
    }

    public static void unselectableLine(String selection, String[] pattern) {
        try {
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            StationController.select();
        }
    }

    public static void positiveInt(String string) {
        try {
            isNotInt(string);
            isNotPositive(string);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            SectionController.run();
        }
    }

    private static void isNotInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throwError("숫자형식이 아닙니다.");
        }
    }

    private static void isNotPositive(String string) {
        if (Integer.parseInt(string) <= 0) {
            throwError("0보다 큰 수이어야 합니다.");
        }
    }

    private static void isUnSelectable(String string, String[] pattern) {
        List<String> patternList = new ArrayList<>(Arrays.asList(pattern));
        if (!patternList.contains(string)) {
            throwError("선택할 수 없는 기능입니다.");
        }
    }

    private static void throwError(String message) {
        throw new CustomException(message);
    }

    public static void duplicatedStation(String name) {
        try {
            isDuplicatedStation(name);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            StationController.run();
        }
    }

    private static void isDuplicatedStation(String name) {
        if (StationRepository.contains(name)) {
            throwError("중복된 지하철 역 이름은 등록될 수 없습니다.");
        }
    }

    public static void stationNameShorterThanTwo(String name) {
        try {
            isShorterThanTwo(name);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            StationController.run();
        }
    }

    public static void lineNameShorterThanTwo(String name) {
        try {
            isShorterThanTwo(name);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            LineController.run();
        }
    }

    private static void isShorterThanTwo(String name) {
        if (name.length() < 2) {
            throwError("지하철 역/노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    public static void stationContainedInLine(String name) {
        try {
            isStationContainedInLine(name);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            StationController.run();
        }
    }

    private static void isStationContainedInLine(String name) {
        if (LineRepository.containsStation(name)) {
            throwError("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }

    public static void lineContained(String line) {
        try {
            isLineContained(line);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            LineController.run();
        }
    }

    private static void isLineContained(String line) {
        if (LineRepository.contains(line)) {
            throwError("중복된 지하철 노선 이름은 등록될 수 없습니다.");
        }
    }

    public static void stationSame(String upwardStation, String downwardStation) {
        try {
            if (upwardStation.equals(downwardStation)) {
                throwError("상행/하행 종점역은 달라야 합니다.");
            }
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            LineController.run();
        }
    }

    public static void notLineContained(String lineName) {
        try {
            isNotLineContained(lineName);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            LineController.run();
        }
    }

    private static void isNotLineContained(String lineName) {
        if (!LineRepository.contains(lineName)) {
            throwError("등록되지 않은 노선에 구간을 추가할 수 없습니다.");
        }
    }

    public static void stationShouldNotBeInLineForAddingToSection(String lineName,
        String stationName) {
        try {
            isStationInLine(lineName, stationName);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            SectionController.run();
        }
    }

    private static void isStationInLine(String lineName, String stationName) {
        if (LineRepository.lineContainsStation(lineName, stationName)) {
            throwError("이미 구간에 있는 역은 추가할 수 없습니다.");
        }
    }

    public static void lineOverflow(String line, String order) {
        try {
            overflow(line, Integer.parseInt(order));
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            SectionController.run();
        }
    }

    private static void overflow(String line, int order) {
        int max = LineRepository.getSectionLength(line) - 1;
        if (order > max) {
            throwError(max + "보다 작아야 합니다.");
        }
    }
}
