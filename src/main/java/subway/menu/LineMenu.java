package subway.menu;

import subway.feature.LineFeature;
import subway.feature.MenuFeature;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.function.Consumer;

public enum LineMenu implements MenuModel {
    REGISTER("1", "노선 등록", (Scanner scanner) -> LineFeature.registerLine(scanner)) ,
    REMOVE("2", "노선 삭제", (Scanner scanner) -> LineFeature.removeLine(scanner)),
    INQUIRY("3", "노선 조회", (Scanner scanner) -> LineFeature.inquiryLine() ),
    BACK("B", "돌아가기", (Scanner scanner) -> {return;});

    final private String selection;
    final private String feature;
    private Consumer<Scanner> move;

    private LineMenu(String selection, String feature, Consumer<Scanner> move) {
        this.selection = selection;
        this.feature = feature;
        this.move = move;
    }

    public static void openScreen(Scanner scanner) {
        OutputView.printLineMenu();
        String lineMenuInput = LineInputView.menu(scanner);
        select(lineMenuInput, scanner);
    }

    private static void select(String lineMenuInput, Scanner scanner) {
        MenuFeature.mapInputToSelection(LineMenu.class, lineMenuInput)
                .getMove().accept(scanner);
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

    @Override
    public Consumer<Scanner> getMove() {
        return move;
    }
}
