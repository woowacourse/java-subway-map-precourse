package subway.menu;

import subway.feature.MenuFeature;
import subway.feature.StationFeature;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Scanner;
import java.util.function.Consumer;

public enum StationMenu implements MenuModel {
    REGISTER("1", "역 등록", (Scanner scanner) -> StationFeature.registerStation(scanner)),
    REMOVE("2", "역 삭제", (Scanner scanner) -> StationFeature.removeStation(scanner)),
    INQUIRY("3", "역 조회", (Scanner scanner) -> StationFeature.inquiryStation()),
    BACK("B", "돌아가기", (Scanner scanner) -> {
        return;
    });

    final private String selection;
    final private String feature;
    final private Consumer<Scanner> move;

    private StationMenu(String selection, String feature, Consumer<Scanner> move) {
        this.selection = selection;
        this.feature = feature;
        this.move = move;
    }

    public static void openScreen(Scanner scanner) {
        OutputView.printStationMenu();
        String stationMenuInput = StationInputView.menu(scanner);

        select(stationMenuInput, scanner);
    }

    private static void select(String stationMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(StationMenu.class, stationMenuInput)
                .getMove().accept(scanner);
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

    @Override
    public Consumer<Scanner> getMove() {
        return move;
    }
}
