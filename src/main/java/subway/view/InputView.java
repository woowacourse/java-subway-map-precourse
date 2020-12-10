package subway.view;

import java.util.Scanner;
import subway.utils.ValidateUtils;

/**
 * 입력값을 받는 클래스
 */
public class InputView {

    private final Scanner scanner;
    private final ValidateUtils validateUtils;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
        validateUtils = new ValidateUtils();
    }

    public String inputValue() {
        return scanner.nextLine();
    }

    public String makeNewStationName() {
        String input = scanner.nextLine();
        validateUtils.isMoreThanTwo(input);
        validateUtils.isNotDuplicateStation(input);
        return input;
    }

    public String makeNewLineName() {
        String input = scanner.nextLine();
        validateUtils.isMoreThanTwo(input);
        validateUtils.isNotDuplicateLine(input);
        return input;
    }

}
