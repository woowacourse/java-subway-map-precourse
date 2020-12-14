package subway.menu;

import subway.feature.MenuFeature;
import subway.feature.SectionFeature;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.util.Scanner;

public enum SectionMenu implements MenuModel {
    REGISTER("1", "구간 등록") {
        public void moveView(Scanner scanner) {
            SectionFeature.registerSection(scanner);
        }
    },
    REMOVE("2", "구간 삭제") {
        public void moveView(Scanner scanner) {
            SectionFeature.removeSection(scanner);
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private SectionMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    public static void openScreen(Scanner scanner) {
        OutputView.printSectionMenu();
        String sectionMenuInput = SectionInputView.menu(scanner);

        select(sectionMenuInput, scanner);
    }

    abstract public void moveView(Scanner scanner);

    private static void select(String sectionMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(SectionMenu.class, sectionMenuInput)
                .moveView(scanner);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(SectionMenu.class);
    }

    @Override
    public String getFeature() {
        return feature;
    }

    @Override
    public String getSelection() {
        return selection;
    }
}
