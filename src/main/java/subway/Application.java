package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayLineMapInitializer subwayLineMapInitializer = new SubwayLineMapInitializer();
        subwayLineMapInitializer.initialize();
        SubwayLineMap subwayLineMap = new SubwayLineMap(scanner);
        subwayLineMap.run();
    }
}
