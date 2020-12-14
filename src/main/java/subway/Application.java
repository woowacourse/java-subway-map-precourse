package subway;

import subway.manager.MainManager;
import subway.manager.Manager;
import subway.util.DummyData;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        DummyData.init();
        Manager manager = new MainManager();
        manager.execute(scanner);
    }
}
