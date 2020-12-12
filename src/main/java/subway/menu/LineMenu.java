package subway.menu;

import subway.view.LineInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum LineMenu {
    REGISTER("1", "노선 등록") {
        public void moveView(Scanner scanner) {
            LineInputView lineInputView = new LineInputView();
            lineInputView.register(scanner);
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
