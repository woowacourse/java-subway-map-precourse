package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.util.MainManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        MainManager mainManager = new MainManager();
        mainManager.appMain(scanner);

    }
}
