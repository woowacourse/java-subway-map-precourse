package subway;

import subway.controller.SubwayMapController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayMapController subwayMap = new SubwayMapController();
        subwayMap.run();
    }
}