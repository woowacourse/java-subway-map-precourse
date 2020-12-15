package subway;

import subway.domain.Line;
import subway.line.LineUtils;
import subway.line.SectionUtils;
import subway.station.StationUtils;
import subway.station.SubwayUtils;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        StationUtils stationUtils = new StationUtils(scanner);
        LineUtils lineUtils = new LineUtils(scanner);
        SectionUtils sectionUtils = new SectionUtils(scanner);
        SubwayUtils subwayUtils = new SubwayUtils(scanner);

        selectUtils(scanner, stationUtils, lineUtils, sectionUtils, subwayUtils);
    }

    public static void selectUtils(Scanner scanner, StationUtils stationUtils, LineUtils lineUtils, SectionUtils sectionUtils, SubwayUtils subwayUtils) {
        while (true) {
            System.out.println("## 메인 화면\n" +
                    "1. 역 관리\n" +
                    "2. 노선 관리\n" +
                    "3. 구간 관리\n" +
                    "4. 지하철 노선도 출력\n" +
                    "Q. 종료\n");
            System.out.println("## 원하는 기능을 선택하세요.");
            String chosen = scanner.next();
            if (chosen.equals("Q")) {
                break;
            }
            choose(chosen, stationUtils, lineUtils, sectionUtils, subwayUtils);
        }
    }

    public static void choose(String chosen, StationUtils stationUtils, LineUtils lineUtils, SectionUtils sectionUtils, SubwayUtils subwayUtils) {
        int number = Integer.parseInt(chosen);

        if (number == 1) {
            stationUtils.play();
        }
        if (number == 2) {
            lineUtils.play();
        }
        if (number == 3) {
            sectionUtils.play();
        }
        if (number == 4) {
            subwayUtils.play();
        }
    }
}
