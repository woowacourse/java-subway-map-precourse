package subway;

import subway.controller.MainMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class SubwayManager {
    private static final String GYODAE = "교대역";
    private static final String GANGNAM = "강남역";
    private static final String YUKSAM = "역삼역";
    private static final String NAMBUTERMINAL = "남부터미널역";
    private static final String YANGJAE = "양재역";
    private static final String YANGJAECITIZENFOREST = "양재시민의숲역";
    private static final String MAEBONG = "매봉역";
    private static final String[] INITIAL_STATIONS =
        {GYODAE, GANGNAM, YUKSAM, NAMBUTERMINAL, YANGJAE, YANGJAECITIZENFOREST, MAEBONG};
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static final int FIRST_STATION = 0;
    private static final int SECOND_STATION = 1;
    private static final int THIRD_STATION = 2;
    private static final int FOURTH_STATION = 3;

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

        Line lineTwo = new Line(LINE_TWO);
        lineTwo.addLineStation(FIRST_STATION, new Station(GYODAE));
        lineTwo.addLineStation(SECOND_STATION, new Station(GANGNAM));
        lineTwo.addLineStation(THIRD_STATION, new Station(YUKSAM));
        LineRepository.addLine(lineTwo);

        Line lineThree = new Line(LINE_THREE);
        lineThree.addLineStation(FIRST_STATION, new Station(GYODAE));
        lineThree.addLineStation(SECOND_STATION, new Station(NAMBUTERMINAL));
        lineThree.addLineStation(THIRD_STATION, new Station(YANGJAE));
        lineThree.addLineStation(FOURTH_STATION, new Station(MAEBONG);
        LineRepository.addLine(lineThree);

        Line lineSinBundang = new Line(LINE_SINBUNDANG);
        lineSinBundang.addLineStation(FIRST_STATION, new Station(GANGNAM));
        lineSinBundang.addLineStation(SECOND_STATION, new Station(YANGJAE));
        lineSinBundang.addLineStation(THIRD_STATION, new Station(YANGJAECITIZENFOREST));
        LineRepository.addLine(lineSinBundang);
    }
}
