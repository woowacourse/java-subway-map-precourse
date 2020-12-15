package subway;

import static subway.StationManage.stationManage;
import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;

public class Application {

    static final String stationManageInput = "1";
    static final String lineManageInput = "2";
    static final String sectionManageInput = "3";
    static final String allLinesInfoPrintInput = "4";
    static final String exitInput = "Q";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initSetting();
        boolean exitFlag = false;
        while (!exitFlag) {
            mainScreenPrint();
            String mainInput = scanner.next();
            exitFlag = ValidateAndNextScreen(scanner, mainInput);
        }
    }

    public static void initSetting() {
        final ArrayList<String> initStations = new ArrayList<>(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        final ArrayList<String> initLines = new ArrayList<>(
            Arrays.asList("2호선", "3호선", "신분당선"));

        for (String stationName : initStations) {
            addStation(new Station(stationName));
        }
        for (String lineName : initLines) {
            addLine(new Line(lineName));
        }
    }

    public static void mainScreenPrint() {
        System.out.println("## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }

    public static boolean ValidateAndNextScreen(Scanner scanner, String mainInput) {
        if (mainInput.equalsIgnoreCase(stationManageInput)) {
            stationManage(scanner);
            return false;
        }
        if (mainInput.equalsIgnoreCase(exitInput)) {
            return true;
        }
        System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        throw new IllegalArgumentException();
    }
}
