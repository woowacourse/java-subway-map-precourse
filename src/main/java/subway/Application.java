package subway;

import subway.domain.station.Station;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        System.out.println("start");
        System.out.println(Station.getStation(scanner.nextLine()));

    }
}
