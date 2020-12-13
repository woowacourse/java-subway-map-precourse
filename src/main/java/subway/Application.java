package subway;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SettingData.load();
        Router router = new Router(scanner);
        router.run();
    }
}
