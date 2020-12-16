package subway.menu;

import subway.feature.MenuFeature;
import subway.feature.SectionFeature;
import subway.view.OutputView;
import subway.view.SectionInputView;

import java.util.Scanner;
import java.util.function.Consumer;

public enum SectionMenu implements MenuModel {
    REGISTER("1", "구간 등록", (Scanner scanner) -> SectionFeature.registerSection(scanner)),
    REMOVE("2", "구간 삭제", (Scanner scanner) -> SectionFeature.removeSection(scanner)),
    BACK("B", "돌아가기", (Scanner scanner) -> {
        return;
    });

    final private String selection;
    final private String feature;
    private Consumer<Scanner> move;

    private SectionMenu(String selection, String feature, Consumer<Scanner> move) {
        this.selection = selection;
        this.feature = feature;
        this.move = move;
    }

    public static void openScreen(Scanner scanner) {
        OutputView.printSectionMenu();
        String sectionMenuInput = SectionInputView.menu(scanner);

        select(sectionMenuInput, scanner);
    }

    private static void select(String sectionMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(SectionMenu.class, sectionMenuInput)
                .getMove().accept(scanner);
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

    @Override
    public Consumer<Scanner> getMove() {
        return move;
    }
}
