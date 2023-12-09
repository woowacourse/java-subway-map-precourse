package subway;

import java.util.Scanner;
import subway.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        AppConfig.initializeStationLine();
    }
}
