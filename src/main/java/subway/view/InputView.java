package subway.view;

import java.util.Scanner;

import static subway.view.resource.Strings.*;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String getStationNameForRegistration() {
        OutputView.printGuide(INPUT_STATION_NAME_FOR_REGISTRATION);
        return SCANNER.nextLine();
    }

    public static String getStationNameForRemoval() {
        OutputView.printGuide(INPUT_STATION_NAME_FOR_REMOVAL);
        return SCANNER.nextLine();
    }

    public static String getFunction() {
        OutputView.printGuide(SELECT_FUNCTION);
        return SCANNER.nextLine();
    }

    public static String getLineNameForRegistration() {
        OutputView.printGuide(INPUT_LINE_NAME_FOR_REGISTRATION);
        return SCANNER.nextLine();
    }

    public static String getTopStation() {
        OutputView.printGuide(INPUT_TOP_STATION);
        return SCANNER.nextLine();
    }

    public static String getBottomStation() {
        OutputView.printGuide(INPUT_BOTTOM_STATION);
        return SCANNER.nextLine();
    }

    public static String getLineNameForRemoval() {
        OutputView.printGuide(INPUT_LINE_NAME_FOR_REMOVAL);
        return SCANNER.nextLine();
    }

    public static String getLineName() {
        OutputView.printGuide(INPUT_LINE);
        return SCANNER.nextLine();
    }

    public static String getStationName() {
        OutputView.printGuide(INPUT_STATION);
        return SCANNER.nextLine();
    }

    public static int getOrder() {
        OutputView.printGuide(INPUT_ORDER);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
