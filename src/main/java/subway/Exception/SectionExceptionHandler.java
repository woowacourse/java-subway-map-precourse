package subway.Exception;

import subway.Controller.LineController;
import subway.domain.LineRepository;
import subway.view.OutputView;

public class SectionExceptionHandler {

    private static final int MIN_LENGTH = 2;

    private static void goBack() {
        LineController.run();
    }

    private static void printErrorAndGoBack(String error) {
        OutputView.printError(error);
        goBack();
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
}
