package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_FUNCTION = "원하는 기능을 선택하세요.";
    private static final String INPUT_STATION_NAME_FOR_REGISTRATION = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_FOR_REMOVAL = "삭제할 역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_FOR_REGISTRATION = "등록할 노선 이름을 입력하세요.";
    private static final String INPUT_TOP_STATION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_BOTTOM_STATION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_LINE_NAME_FOR_REMOVAL = "삭제할 노선 이름을 입력하세요.";

    private InputView() {
    }

    public static String getStationNameForRegistration() {
        OutputView.printGuideMessage(INPUT_STATION_NAME_FOR_REGISTRATION);
        return SCANNER.nextLine();
    }

    public static String getStationNameForRemoval() {
        OutputView.printGuideMessage(INPUT_STATION_NAME_FOR_REMOVAL);
        return SCANNER.nextLine();
    }

    public static String getFunction() {
        OutputView.printGuideMessage(INPUT_FUNCTION);
        return SCANNER.nextLine();
    }

    public static String getLineNameForRegistration() {
        OutputView.printGuideMessage(INPUT_LINE_NAME_FOR_REGISTRATION);
        return SCANNER.nextLine();
    }

    public static String getTopStation() {
        OutputView.printGuideMessage(INPUT_TOP_STATION);
        return SCANNER.nextLine();
    }

    public static String getBottomStation() {
        OutputView.printGuideMessage(INPUT_BOTTOM_STATION);
        return SCANNER.nextLine();
    }

    public static String getLineNameForRemoval() {
        OutputView.printGuideMessage(INPUT_LINE_NAME_FOR_REMOVAL);
        return SCANNER.nextLine();
    }
}
