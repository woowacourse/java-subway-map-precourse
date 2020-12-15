package subway;

import subway.controller.SubwayController;

import java.util.Scanner;

/**
 * Application.java : 메인 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayController subwayController = new SubwayController();
        subwayController.runSubway(scanner);
    }
}
