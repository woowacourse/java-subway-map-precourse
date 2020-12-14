package subway.menu;

import subway.feature.MenuFeature;
import subway.feature.SectionFeature;
import subway.view.MainInputView;
import subway.view.OutputView;

import java.util.Scanner;

public enum MainMenu implements MenuModel {
    MANAGE_STATION("1", "역 관리") {
        public void moveView(Scanner scanner) {
            StationMenu.openScreen(scanner);
        }
    },
    MANAGE_LINE("2", "노선 관리") {
        public void moveView(Scanner scanner) {
            LineMenu.openScreen(scanner);
        }
    },
    MANAGE_SECTION("3", "구간 관리") {
        public void moveView(Scanner scanner) {
            SectionMenu.openScreen(scanner);
        }
    },
    SHOW_MAP("4", "지하철 노선 출력") {
        public void moveView(Scanner scanner) {
            SectionFeature.showSubwayMap();
        }
    },
    QUIT("Q", "종료") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private MainMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

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
                .moveView(scanner);
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
}
