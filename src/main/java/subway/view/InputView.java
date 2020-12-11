package subway.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_STATION_NAME_FOR_REGISTRATION = "등록할 역 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_FOR_REMOVAL = "삭제할 역 이름을 입력하세요.";

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
}
