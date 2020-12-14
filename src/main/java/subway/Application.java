package subway;

import subway.domain.SubwayMap;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayMap.start(scanner);
    }
}
