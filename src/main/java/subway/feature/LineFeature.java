package subway.feature;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.menu.LineMenu;
import subway.view.ErrorView;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineFeature {

    public static void registerLine(Scanner scanner) {
        try {
            String lineName = LineInputView.register(scanner).trim();
            String upBoundTerminus = LineInputView.upBoundTerminus(scanner).trim();
            String downBoundTerminus = LineInputView.downBoundTerminus(scanner).trim();

            LineRepository.addLine(new Line(lineName).addTerminus(upBoundTerminus, downBoundTerminus));
            OutputView.printSuccessRegisterLine();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            LineMenu.openScreen(scanner);
        }
    }

    public static void removeLine(Scanner scanner) {
        try {
            String lineName = LineInputView.remove(scanner);

            removeLine(LineRepository.deleteLineByName(lineName));
            OutputView.printSuccessRemoveLine();
        } catch (IllegalArgumentException e) {
            ErrorView.printError(e.getMessage());
            LineMenu.openScreen(scanner);
        }
    }

    private static void removeLine(boolean success) {
        if (!success) {
            throw new IllegalArgumentException(ErrorView.NO_EXIST_LINE);
        }
    }

    public static void inquiryLine() {
        OutputView.printLines();
    }
}
