package subway.menu;

import subway.view.LineInputView;
import subway.view.SectionInputView;
import subway.view.StationInputView;

import java.util.Scanner;

public enum MainMenu implements MenuModel {
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

    public static boolean canContinue(String mainMenuInput) {
        return !MainMenu.QUIT.selection.equals(mainMenuInput);
    }

    public static MenuModel select(String mainMenuInput) {
        return MenuFeature.findOne(MainMenu.class, mainMenuInput);
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
