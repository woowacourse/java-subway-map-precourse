package subway;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import subway.domain.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Settings.init();
        StationRepository.printStations();
        LineRepository.printLines();
    }
}

