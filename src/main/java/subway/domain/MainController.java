package subway.domain;

import subway.domain.line.Line;
import subway.domain.line.LineController;
import subway.domain.line.LineRepository;
import subway.domain.section.Section;
import subway.domain.section.SectionController;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationController;
import subway.domain.station.StationRepository;
import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;
import subway.util.PrefixPrinter;

import java.util.Arrays;
import java.util.Scanner;

public class MainController implements MenuSelectManager {
    private static final String QUIT = "Q";
    private static final String MANAGE_STATION = "1";
    private static final String MANAGE_LINE = "2";
    private static final String MANAGE_SECTION = "3";
    private static final String PRINT_SUBWAY_MAP = "4";
    private static MenuSelectManager menuSelectManager;

    static Station[] initStation = new Station[]{
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("양재시민의숲역"),
            new Station("매봉역")};
    static Line[] initLine = new Line[]{
            new Line("2호선"),
            new Line("3호선"),
            new Line("신분당선")};
    static Section[] initSection = new Section[]{
            new Section("2호선", "교대역", 1),
            new Section("2호선", "강남역", 2),
            new Section("2호선", "역삼역", 3),
            new Section("3호선", "교대역", 1),
            new Section("3호선", "남부터미널역", 2),
            new Section("3호선", "양재역", 3),
            new Section("3호선", "매봉역", 4),
            new Section("신분당선", "강남역", 1),
            new Section("신분당선", "양재역", 2),
            new Section("신분당선", "양재시민의숲역", 3)};

    public void init() {
        Arrays.stream(initStation).forEach(StationRepository::addStation);
        Arrays.stream(initLine).forEach(LineRepository::addLine);
        Arrays.stream(initSection).forEach(SectionRepository::addSection);
    }

    @Override
    public void selectMenu(Scanner scanner) {
        MenuPrinter.printMainMenu();
        String menuInput = scanner.next();
        while (!menuInput.equals(QUIT)) {
            System.out.println();
            if (!validateMenuInput(menuInput)) {
                MenuPrinter.printMainMenu();
                menuInput = scanner.next();
                continue;
            }
            setController(menuInput);
            menuSelectManager.selectMenu(scanner);
            MenuPrinter.printMainMenu();
            menuInput = scanner.next();
        }
    }

    private boolean validateMenuInput(String menuInput) {
        if (!menuInput.equals(MANAGE_STATION) && !menuInput.equals(MANAGE_LINE)
                && !menuInput.equals(MANAGE_SECTION) && !menuInput.equals(PRINT_SUBWAY_MAP)) {
            PrefixPrinter.printError("선택할 수 없는 기능입니다.");
            return false;
        }
        return true;
    }

    private void setController(String menuInput) {
        if (menuInput.equals(MANAGE_STATION)) {
            menuSelectManager = new StationController();
        }
        if (menuInput.equals(MANAGE_LINE)) {
            menuSelectManager = new LineController();
        }
        if (menuInput.equals(MANAGE_SECTION)) {
            menuSelectManager = new SectionController();
        }
        if (menuInput.equals(PRINT_SUBWAY_MAP)) {
            menuSelectManager = new SubwayMapPrinter();
        }
    }
}
