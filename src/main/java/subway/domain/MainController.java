package subway.domain;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;

import java.util.Scanner;

public class MainController implements MenuSelectManager {
    private static final String QUIT = "Q";
    private static final String MANAGE_STATION = "1";
    private static final String MANAGE_LINE = "2";
    private static final String MANAGE_SECTION = "3";
    private static final String PRINT_SUBWAY_MAP = "4";
    public void init() {
        // 역 등록 (교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역)
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        // 노선 등록 (2호선, 3호선, 신분당선)
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));

        // 구간 등록
        //   - 2호선: 교대역 - 강남역 - 역삼역
        //   - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
        //   - 신분당선: 강남역 - 양재역 - 양재시민의숲역
        SectionRepository.addSection("2호선", "교대역", 0);
        SectionRepository.addSection("2호선", "강남역", 1);
        SectionRepository.addSection("2호선", "역삼역", 2);
        SectionRepository.addSection("3호선", "교대역", 0);
        SectionRepository.addSection("3호선", "남부터미널역", 1);
        SectionRepository.addSection("3호선", "양재역", 2);
        SectionRepository.addSection("3호선", "매봉역", 3);
        SectionRepository.addSection("신분당선", "강남역", 0);
        SectionRepository.addSection("신분당선", "양재역", 1);
        SectionRepository.addSection("신분당선", "양재시민의숲역", 2);
    }

    @Override
    public void forward(Scanner scanner) {
        StationController stationController = new StationController();
        LineController lineController = new LineController();
        SectionController sectionController = new SectionController();
        MenuPrinter.printMainMenu();
        String menuInput = scanner.next();
        while(!menuInput.equals(QUIT)) {
            System.out.println();
            if (menuInput.equals(MANAGE_STATION)) {
                stationController.forward(scanner);
            }
            if (menuInput.equals(MANAGE_LINE)) {
                lineController.forward(scanner);
            }
            if (menuInput.equals(MANAGE_SECTION) || menuInput.equals(PRINT_SUBWAY_MAP)) {
                sectionController.forward(scanner);
            }
            MenuPrinter.printMainMenu();
            menuInput = scanner.next();
        }
    }
}
