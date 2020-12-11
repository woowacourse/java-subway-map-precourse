package subway.view.menu;

import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenu {
    public static void print() {
        OutputView.printSectionMenu();
        String selection = InputView.receiveMenu("Section");

        if (selection.equals("1")) {
            // 구간 등록
            return;
        }
        if (selection.equals("2")) {
            // 구간 삭제
            return;
        }
        if (selection.equals("B")) {
            MainMenu.print();
            return;
        }
    }
}
