package subway;

import java.util.Scanner;
import subway.domain.DataInitialization;
import subway.domain.SubwayManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DataInitialization.initialize();
        SubwayManager subwayManager = new SubwayManager();
        subwayManager.execute(scanner);
    }
}
