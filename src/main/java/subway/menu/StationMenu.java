package subway.menu;

import subway.feature.StationFeature;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Scanner;

public enum StationMenu implements MenuModel {
    REGISTER("1", "역 등록") {
        public void moveView(Scanner scanner) {
            StationFeature.registerStation(scanner);
        }
    },
    REMOVE("2", "역 삭제") {
        public void moveView(Scanner scanner) {
            StationFeature.removeStation(scanner);
        }
    },
    INQUIRY("3", "역 조회") {
        public void moveView(Scanner scanner) {
            StationFeature.inquiryStation();
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private StationMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static void openScreen(Scanner scanner) {
        OutputView.printStationMenu();
        String stationMenuInput = StationInputView.menu(scanner);

        select(stationMenuInput, scanner);
    }

    private static void select(String stationMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(StationMenu.class, stationMenuInput)
                .moveView(scanner);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(StationMenu.class);
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
