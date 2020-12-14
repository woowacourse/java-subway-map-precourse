package subway.views.lineviews;

import subway.menus.LineMenu;
import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class LineInputView implements InputView {
    private static final String INPUT_LINE_NAME_MESSAGE = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_UPWARD_END_NAME_MESSAGE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_DOWNWARD_END_NAME_MESSAGE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";

    private LineInputView() {
    }

    public static LineMenu selectLineMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return LineMenu.getMenu(InputView.userInput(scanner));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectLineMenu(scanner);
        }
    }

    public static String inputLineName(Scanner scanner) {
        System.out.println(INPUT_LINE_NAME_MESSAGE);
        return InputView.userInput(scanner);
    }

    public static String inputUpwardEndStation(Scanner scanner) {
        System.out.println(INPUT_UPWARD_END_NAME_MESSAGE);
        return InputView.userInput(scanner);
    }

    public static String inputDownwardEndStation(Scanner scanner) {
        System.out.println(INPUT_DOWNWARD_END_NAME_MESSAGE);
        return InputView.userInput(scanner);
    }
}
