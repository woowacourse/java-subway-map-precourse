package subway.view;

import java.util.Scanner;
import subway.utils.ValidateUtils;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputValue() {
        return scanner.nextLine();
    }

    public static String makeNewStationName() {
        String input = scanner.nextLine();
        ValidateUtils.isMoreThanTwo(input);
        ValidateUtils.isNotDuplicateStation(input);
        return input;
    }

    public static String makeNewLineName() {
        String input = scanner.nextLine();
        ValidateUtils.isMoreThanTwo(input);
        ValidateUtils.isNotDuplicateLine(input);
        return input;
    }

}
