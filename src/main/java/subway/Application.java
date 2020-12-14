package subway;

import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        SubwayController subwayController = new SubwayController();
        subwayController.start();
    }
}
