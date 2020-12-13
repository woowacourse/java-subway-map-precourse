package subway.Exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.MainController;
import subway.Controller.StationController;
import subway.domain.StationRepository;
import subway.view.OutputView;

public class ExceptionHandler {

    public static void unselectable(String selection, String[] pattern) {
        try {
            ExceptionHandler.isUnSelectable(selection, pattern);
        } catch (CustomException e) {
            OutputView.printError(e.getMessage());
            MainController.run();
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
            throwError("지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }
}
