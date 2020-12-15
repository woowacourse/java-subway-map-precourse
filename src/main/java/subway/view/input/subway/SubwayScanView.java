package subway.view.input.subway;

import subway.view.output.util.ScreenView;

import java.util.Scanner;

/**
 * SubwayScanView.java : 지하철 기능 입력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SubwayScanView {
    public static String scanMainInputForManagement(Scanner scanner) {
        ScreenView.printMainScreen();
        return scanner.nextLine();
    }
}
