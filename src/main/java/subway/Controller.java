package subway;

import subway.domain.*;
import subway.menu.MainMenu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Scanner SCANNER;

    public Controller(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public void run() {
        initialize();
        MainMenu.openScreen(SCANNER);
    }

    // 사전 등록 정보로 초기 설정
    private void initialize() {
        List<Station> stations = Arrays.asList(new Station("교대역"), new Station("강남역")
                    , new Station("역삼역"), new Station("남부터미널역"), new Station("양재역")
                    , new Station("양재시민의숲역"), new Station("매봉역"));
        stations.stream().forEach(station -> StationRepository.addStation(station));

        List<Line> lines = Arrays.asList(new Line("2호선").addTerminus("교대역", "역삼역")
                , new Line("3호선").addTerminus("교대역", "매봉역")
                , new Line("신분당선").addTerminus("강남역", "양재시민의숲역"));
        lines.stream().forEach(line -> LineRepository.addLine(line));

        SectionRepository.addSection("2호선", "강남역", 1);
        SectionRepository.addSection("3호선", "남부터미널역", 1);
        SectionRepository.addSection("3호선", "양재역", 2);
        SectionRepository.addSection("신분당선", "양재역", 1);
    }

}
