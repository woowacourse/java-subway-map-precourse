package subway.menu;

import subway.view.LineInputView;
import subway.view.SectionInputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum MainMenu {
    MANAGE_STATION("1", "역 관리") {
        public void moveView(Scanner scanner) {
            String stationViewInput = StationInputView.menu(scanner);
            StationMenu.select(stationViewInput).moveView(scanner);
        }
    },
    MANAGE_LINE("2", "노선 관리") {
        public void moveView(Scanner scanner) {
            String lineViewInput = LineInputView.menu(scanner);
            LineMenu.select(lineViewInput).moveView(scanner);
        }
    },
    MANAGE_SECTION("3", "구간 관리") {
        public void moveView(Scanner scanner) {
            String sectionViewInput = SectionInputView.menu(scanner);
            SectionMenu.select(sectionViewInput).moveView(scanner);
        }
    },
    SHOW_MAP("4", "지하철 노선 출력") {
        public void moveView(Scanner scanner) {
            System.out.println("지하철 노선 출력");
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

    public static MainMenu select(String mainMenuInput) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> menu.selection.equals(mainMenuInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String validateInput(String mainMenuInput) {
        return select(mainMenuInput).selection;
    }

    public static String getMenu() {
        String menuText = "";
        for (MainMenu mainMenu : MainMenu.values()) {
            menuText += mainMenu.selection + ". " + mainMenu.feature + "\n";
        }
        return menuText;
    }

    public static boolean canContinue(String mainMenuInput) {
        return !MainMenu.QUIT.selection.equals(mainMenuInput);
    }
}
