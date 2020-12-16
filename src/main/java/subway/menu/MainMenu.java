package subway.menu;

import subway.feature.MenuFeature;
import subway.feature.SectionFeature;
import subway.view.MainInputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.function.Consumer;

public enum MainMenu implements MenuModel {
    MANAGE_STATION("1", "역 관리", (Scanner scanner) -> StationMenu.openScreen(scanner)),
    MANAGE_LINE("2", "노선 관리", (Scanner scanner) -> LineMenu.openScreen(scanner)),
    MANAGE_SECTION("3", "구간 관리", (Scanner scanner) -> SectionMenu.openScreen(scanner)),
    SHOW_MAP("4", "지하철 노선 출력", (Scanner scanner) -> SectionFeature.showSubwayMap()),
    QUIT("Q", "종료", (Scanner scanner) -> {
        return;
    });

    final private String selection;
    final private String feature;
    final private Consumer<Scanner> move;

    private MainMenu(String selection, String feature, Consumer<Scanner> move) {
        this.selection = selection;
        this.feature = feature;
        this.move = move;
    }

    public static void openScreen(Scanner scanner) {
        String mainMenuInput = "";
        do {
            OutputView.printMainMenu();
            mainMenuInput = MainInputView.mainMenu(scanner);

            select(mainMenuInput, scanner);
        } while (canContinue(mainMenuInput));
    }

    private static void select(String mainMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(MainMenu.class, mainMenuInput)
                .getMove().accept(scanner);
    }

    private static boolean canContinue(String mainMenuInput) {
        return !MainMenu.QUIT.selection.equals(mainMenuInput);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(MainMenu.class);
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
