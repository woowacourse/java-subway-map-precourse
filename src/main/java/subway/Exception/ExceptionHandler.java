package subway.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.LineController;
import subway.Controller.MainController;
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

    public static void isNotInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (CustomException e) {
            throwError("숫자 형식이어야 합니다.");
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
            throwError("중복된 지하철 역 이름인 등록될 수 없습니다.");
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
        if (LineRepository.containsLine(line)) {
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
}
