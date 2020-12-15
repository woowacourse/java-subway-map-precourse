package subway.exception.domain;

import subway.controller.domain.LineController;
import subway.domain.LineRepository;
import subway.exception.CustomException;
import subway.view.OutputView;

public class LineExceptionHandler {

    private static final int MIN_LENGTH = 2;

    private static void goBack() {
        LineController.run();
    }

    private static void printErrorAndGoBack(String error) {
        OutputView.printError(error);
        goBack();
    }

    public static void lineNameShortThanMin(String lineName) {
        try {
            if (lineName.length() < MIN_LENGTH) {
                throw new CustomException("지하철 노선 이름은 2글자 이상이어야 합니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void lineDuplicated(String lineName) {
        try {
            if (LineRepository.contains(lineName)) {
                throw new CustomException("중복된 지하철 노선은 등록될 수 없습니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }

    public static void fromAndToStationDuplicated(String from, String to) {
        try {
            if (from.equals(to)) {
                throw new CustomException("상행/하행 종점의 이름은 달라야 합니다.");
            }
        } catch (CustomException e) {
            printErrorAndGoBack(e.getMessage());
        }
    }
}
