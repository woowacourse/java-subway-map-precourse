package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SectionMenu {
    public static void goToSectionMenu() {
        OutputView.printSectionMenu();
        String selection = InputView.receiveMenu("Section");
        if (selection.equals("1")) {
            // 구간 등록
        }
        if (selection.equals("2")) {
            // 구간 삭제
        }
    }
}
