package subway;

import subway.controller.MainMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class SubwayManager {
    private static final String[] INITIAL_STATIONS =
        {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};

    public SubwayManager() {
        settingInitialSubways();
    }

    public void run(Scanner scanner) {
        MainMenuController mainMenuController = new MainMenuController();
        mainMenuController.mappingMainMenu(scanner);
    }

    private void settingInitialSubways() {
        Arrays.asList(INITIAL_STATIONS).stream()
            .map(Station::new)
            .forEach(StationRepository::addStation);

        Line line1 = new Line("2호선");
        line1.addLineStation(0, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("교대역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line1.addLineStation(1, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("강남역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line1.addLineStation(2, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("역삼역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        LineRepository.addLine(line1);

        Line line2 = new Line("3호선");
        line2.addLineStation(0, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("교대역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line2.addLineStation(1, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("남부터미널역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line2.addLineStation(2, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("양재역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line2.addLineStation(3, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("매봉역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        LineRepository.addLine(line2);

        Line line3 = new Line("신분당선");
        line3.addLineStation(0, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("강남역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line3.addLineStation(1, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("양재역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        line3.addLineStation(2, StationRepository.stations().stream()
            .filter(s -> s.getName().equals("양재시민의숲역")).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 역이 없습니다.")));
        LineRepository.addLine(line3);
    }
}
