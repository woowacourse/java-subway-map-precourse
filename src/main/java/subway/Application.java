package subway;

import static log.Logger.displayInputScreen;
import static log.Logger.displayMainScreen;
import static subway.LineManage.linaManage;
import static subway.StationManage.stationManage;
import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;
import static subway.routeMap.routeMapPrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;

public class Application {

    static final String STATION_MANAGE = "1";
    static final String LINE_MANAGE = "2";
    static final String SECTION_MANAGE = "3";
    static final String ALL_INFO = "4";
    static final String EXIT = "Q";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initSetting();
        boolean exitFlag = false;
        while (!exitFlag) {
            displayMainScreen();
            exitFlag = isExit(scanner);
        }
    }

    private static void initSetting() {
        final ArrayList<String> initStations = new ArrayList<>(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));

        for (String stationName : initStations) {
            addStation(new Station(stationName));
        }
        addLine(new Line("2호선", new LinkedList<Station>(Arrays.asList(
            new Station("교대역"), new Station("강남역"), new Station("역삼역")))));
        addLine(new Line("3호선", new LinkedList<Station>(Arrays.asList(
            new Station("교대역"), new Station("남부터미널역"),
            new Station("양재역"), new Station("매봉역")))));
        addLine(new Line("신분당선", new LinkedList<Station>(Arrays.asList(
            new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역")))));
    }

    private static boolean isExit(Scanner scanner) {
        String input = displayInputScreen(scanner, new ArrayList<>(Arrays.asList(
            STATION_MANAGE, LINE_MANAGE, SECTION_MANAGE, ALL_INFO, EXIT)));

        if (input.equals(EXIT)) {
            return true;
        }
        if (input.equals(STATION_MANAGE)) {
            stationManage(scanner);
        }
        if (input.equals(LINE_MANAGE)) {
            linaManage(scanner);
        }
        if (input.equals(SECTION_MANAGE)) {
            //sectionManage(scanner);
        }
        if (input.equals(ALL_INFO)) {
            routeMapPrint();
        }
        return false;
    }
}
