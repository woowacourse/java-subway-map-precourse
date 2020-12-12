package subway;

import java.util.Scanner;
import subway.dashboard.MainDashboard;
import subway.domain.StationRepository;
import subway.view.InputView;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        InputView inputView = new InputView(scanner);
        InitialData initialData = new InitialData();
        MainDashboard mainDashboard = new MainDashboard(inputView);
    }
}
