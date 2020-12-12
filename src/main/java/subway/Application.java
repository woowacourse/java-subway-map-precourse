package subway;

import java.util.Scanner;
import subway.dashboard.MainDashboard;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        MainDashboard mainDashboard = new MainDashboard(scanner);
    }
}
