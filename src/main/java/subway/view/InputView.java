package subway.view;

import java.util.Scanner;

import static subway.view.resource.LineMessage.*;
import static subway.view.resource.SectionMessage.*;
import static subway.view.resource.StationMessage.INPUT_STATION_NAME_FOR_REGISTRATION;
import static subway.view.resource.StationMessage.INPUT_STATION_NAME_FOR_REMOVAL;


public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_FUNCTION = "원하는 기능을 선택하세요.";

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

    public static String getLineName() {
        OutputView.printGuideMessage(INPUT_LINE);
        return SCANNER.nextLine();
    }

    public static String getStation() {
        OutputView.printGuideMessage(INPUT_STATION);
        return SCANNER.nextLine();
    }

    public static String getOrder() {
        OutputView.printGuideMessage(INPUT_ORDER);
        return SCANNER.nextLine();
    }
}
