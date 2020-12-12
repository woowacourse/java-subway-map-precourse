package subway.menu;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineInputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum LineMenu {
    REGISTER("1", "노선 등록") {
        public void moveView(Scanner scanner) {
            String line = LineInputView.register(scanner);
            String upBoundTerminus = LineInputView.upBoundTerminus(scanner);
            String downBoundTerminus = LineInputView.downBoundTerminus(scanner);

            Line newLine = new Line(line);
            newLine.addTerminus(upBoundTerminus, downBoundTerminus);
            LineRepository.addLine(newLine);
        }
    },
    REMOVE("2", "노선 삭제") {
        public void moveView(Scanner scanner) {
            LineInputView lineInputView = new LineInputView();
            lineInputView.remove(scanner);
        }
    },
    INQUIRY("3", "노선 조회") {
        public void moveView(Scanner scanner) {
            // 모든 역 출력
            // LineRepository..
            LineRepository.lines().stream().forEach(x -> System.out.println(x.getName()+ " "+ x.line.getFirst() + " " + x.line.getLast()));
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    abstract public void moveView(Scanner scanner);

    private LineMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    public static LineMenu select(String lineMenuInput) {
        return Arrays.stream(LineMenu.values())
                .filter(menu -> menu.selection.equals(lineMenuInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String validateInput(String lineMenuInput) {
        return select(lineMenuInput).selection;
    }

    public static String getMenu() {
        String menuText = "";
        for (LineMenu lineMenu : LineMenu.values()) {
            menuText += lineMenu.selection + ". " + lineMenu.feature + "\n";
        }
        return menuText;
    }
}
