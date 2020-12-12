package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class LineMenu {
    public static void print() {
        OutputView.printLineMenu();
        String selection = InputView.receiveMenu("Line");

        if (selection.equals("1")) {
            // 노선 등록
            return;
        }
        if (selection.equals("2")) {
            // 노선 삭제
            return;
        }
        if (selection.equals("3")) {
            // 노선 조회
            return;
        }
        if (selection.equals("B")) {
            MainMenu.print();
            return;
        }
    }
}
