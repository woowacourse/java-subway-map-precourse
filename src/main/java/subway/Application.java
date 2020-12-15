package subway;

import static log.ErrorCase.FUNCTION_INPUT_ERROR;
import static log.Logger.displayMainScreen;
import static log.Logger.errorPrint;
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
            String mainInput = scanner.next();
            exitFlag = checkInput(scanner, mainInput);
        }
    }

    private static void initSetting() {
        final ArrayList<String> initStations = new ArrayList<>(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        final ArrayList<String> initLines = new ArrayList<>(
            Arrays.asList("2호선", "3호선", "신분당선"));

        for (String stationName : initStations) {
            addStation(new Station(stationName));
        }
        addLine(new Line("2호선",
            new LinkedList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역")
            ))));
        addLine(new Line("3호선",
            new LinkedList<Station>(Arrays.asList(
                new Station("교대역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역")
            ))));
        addLine(new Line("3호선",
            new LinkedList<Station>(Arrays.asList(
                new Station("신분당선"),
                new Station("강남역"),
                new Station("양재역"),
                new Station("양재시민의숲역")
            ))));
    }

    private static boolean checkInput(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(STATION_MANAGE)) {
            stationManage(scanner);
            return false;
        }
        if (mainInput.equalsIgnoreCase(LINE_MANAGE)) {
            linaManage(scanner);
            return false;
        }
        if (mainInput.equalsIgnoreCase(SECTION_MANAGE)) {
            //sectionManage(scanner);
            return false;
        }
        if (mainInput.equalsIgnoreCase(ALL_INFO)) {
            routeMapPrint();
            return false;
        }
        if (mainInput.equalsIgnoreCase(EXIT)) {
            return true;
        }
        errorPrint(FUNCTION_INPUT_ERROR);
        throw new IllegalArgumentException();
    }
}
