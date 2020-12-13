package subway;


import subway.controller.SubwayManager;

public class Application {
    public static void main(String[] args) {
        SubwayManager subwayManager = new SubwayManager();
        subwayManager.run();
    }
}
