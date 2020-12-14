package subway;

import java.util.Scanner;

import subway.dashboard.MainDashboard;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        InitialData initialData = new InitialData();
        MainDashboard mainDashboard = new MainDashboard(inputView);
    }
}
