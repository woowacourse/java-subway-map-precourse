package subway.feature;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.menu.StationMenu;
import subway.view.LineInputView;

import java.util.Scanner;

public class LineFeature {

    public static void registerLine(Scanner scanner) {
        try {
            String line = LineInputView.register(scanner);
            String upBoundTerminus = LineInputView.upBoundTerminus(scanner);
            String downBoundTerminus = LineInputView.downBoundTerminus(scanner);

            Line newLine = new Line(line);
            newLine.addTerminus(upBoundTerminus, downBoundTerminus);
            LineRepository.addLine(newLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    public static void removeLine(Scanner scanner) {
        try {
            LineInputView lineInputView = new LineInputView();
            lineInputView.remove(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }
}
