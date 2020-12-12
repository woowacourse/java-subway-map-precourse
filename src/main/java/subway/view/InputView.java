package subway.view;

import java.util.Scanner;
import subway.utils.Message;
import subway.utils.Validator;

public class InputView implements Message {

    private static final Scanner scanner = new Scanner(System.in);


    public static String getSelection() {
        OutputView.displaySelection();
        return getInput();
    }

    public static String getStationName() {
        OutputView.printAnnouncement(ANN_REGISTER_STATION);
        String name = getInput();
        Validator.checkValidStationName(name);
        return name;
    }

    public static String getLineName() {
        OutputView.printAnnouncement(ANN_REGISTER_LINE);
        String name = getInput();
        Validator.checkValidLineName(name);
        return name;
    }

    public static String getInput() {
        return scanner.nextLine().trim();
    }

}
