package subway;

import subway.controller.SubwayController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = new SubwayController();
        subwayController.start();
    }
}
