package subway.feature;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.menu.LineMenu;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineFeature {

    public static void registerLine(Scanner scanner) {
        try {
            String name = LineInputView.register(scanner).trim();
            String upBoundTerminus = LineInputView.upBoundTerminus(scanner).trim();
            String downBoundTerminus = LineInputView.downBoundTerminus(scanner).trim();

            LineRepository.addLine(new Line(name).addTerminus(upBoundTerminus, downBoundTerminus));

            System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            LineMenu.openScreen(scanner);
        }
    }

    public static void removeLine(Scanner scanner) {
        try {
            String name = LineInputView.remove(scanner);
            removeLine(LineRepository.deleteLineByName(name));
            System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            LineMenu.openScreen(scanner);
        }
    }

    private static void removeLine(boolean success) {
        if (!success) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
        }
    }

    public static void inquiryLine() {
        System.out.println("[INFO] 노선 목록");
        OutputView.printLines();
    }
}
