package subway.menu;

import subway.feature.LineFeature;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.util.Scanner;

public enum LineMenu implements MenuModel {
    REGISTER("1", "노선 등록") {
        public void moveView(Scanner scanner) {
            LineFeature.registerLine(scanner);
        }
    },
    REMOVE("2", "노선 삭제") {
        public void moveView(Scanner scanner) {
            LineFeature.removeLine(scanner);
        }
    },
    INQUIRY("3", "노선 조회") {
        public void moveView(Scanner scanner) {
            LineFeature.inquiryLine();
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private LineMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static void openScreen(Scanner scanner) {
        OutputView.printLineMenu();
        String lineMenuInput = LineInputView.menu(scanner);

        select(lineMenuInput, scanner);
    }

    private static void select(String lineMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(LineMenu.class, lineMenuInput)
                .moveView(scanner);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(LineMenu.class);
    }

    @Override
    public String getSelection() {
        return selection;
    }

    @Override
    public String getFeature() {
        return feature;
    }
}
