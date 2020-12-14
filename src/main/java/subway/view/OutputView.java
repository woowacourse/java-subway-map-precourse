package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.menu.LineMenu;
import subway.menu.MainMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;

public class OutputView extends View{

    private static final String LINE_LIST = "노선 목록";
    private static final String STATION_LIST = "역 목록";
    private static final String SUBWAY_MAP = "지하철 노선도";
    private static final String MAIN_SCREEN = "메인 화면";
    private static final String LINE_SCREEN = "노선 관리 화면";
    private static final String SECTION_SCREEN = "구간 관리 화면";
    private static final String STATION_SCREEN = "지하철 관리 화면";
    private static final String SUCCESS_REGISTER_LINE = "지하철 노선이 등록되었습니다.";
    private static final String SUCCESS_REGISTER_SECTION = "지하철 구간이 등록되었습니다.";
    private static final String SUCCESS_REGISTER_STATION = "지하철 역이 등록되었습니다.";
    private static final String SUCCESS_REMOVE_LINE = "지하철 노선이 삭제되었습니다.";
    private static final String SUCCESS_REMOVE_SECTION = "지하철 구간이 삭제되었습니다.";
    private static final String SUCCESS_REMOVE_STATION = "지하철 역이 삭제되었습니다.";

    public static void printMainMenu() {
        newLine();
        System.out.println(POUND_KEY + MAIN_SCREEN);
        System.out.println(MainMenu.getMenu());
    }

    public static void printLineMenu() {
        newLine();
        System.out.println(POUND_KEY + LINE_SCREEN);
        System.out.println(LineMenu.getMenu());
    }

    public static void printSectionMenu() {
        newLine();
        System.out.println(POUND_KEY + SECTION_SCREEN);
        System.out.println(SectionMenu.getMenu());
    }

    public static void printStationMenu() {
        newLine();
        System.out.println(POUND_KEY + STATION_SCREEN);
        System.out.println(StationMenu.getMenu());
    }

    public static void printLines() {
        newLine();
        System.out.println(INFO + LINE_LIST);
        LineRepository.lines().stream()
                .forEach(line -> System.out.println(INFO + line.getName()));
    }

    public static void printStations() {
        newLine();
        System.out.println(POUND_KEY + STATION_LIST);
        StationRepository.stations().stream()
                .forEach(station -> System.out.println(INFO + station.getName()));
    }

    public static void printStationsByLine(Line line) {
        newLine();
        System.out.println(INFO + line.getName());
        System.out.println(CUTOFF_LINE);
        line.stations().stream()
                .forEach(station -> System.out.println(INFO + station.getName()));
    }

    public static void printSuccessRegisterLine() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REGISTER_LINE);
    }

    public static void printSuccessRegisterSection() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REGISTER_SECTION);
    }

    public static void printSuccessRegisterStation() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REGISTER_STATION);
    }

    public static void printSuccessRemoveLine() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REMOVE_LINE);
    }

    public static void printSuccessRemoveSection() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REMOVE_SECTION);
    }

    public static void printSuccessRemoveStation() {
        newLine();
        System.out.println(POUND_KEY + SUCCESS_REMOVE_STATION);
    }

    public static void printSubwayMap() {
        newLine();
        System.out.println(POUND_KEY + SUBWAY_MAP);
        LineRepository.lines().stream()
                .forEach(line -> OutputView.printStationsByLine(line));
    }
}
