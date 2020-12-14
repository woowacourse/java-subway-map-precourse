package subway.view;

import subway.domain.line.model.Line;
import subway.domain.station.model.Station;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_WANTED_FUNCTION_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String INPUT_WANTED_STATION_NAME_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String INPUT_WANTED_DELETE_STATION_NAME_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    private static final String INPUT_WANTED_LINE_NAME_MESSAGE = "## 등록할 노선 이름을 입력하세요";
    private static final String INPUT_WANTED_UP_BOUND_STATION_NAME_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_WANTED_DOWN_BOUND_STATION_NAME_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INPUT_WANTED_DELETE_LINE_NAME_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String INPUT_STATION_NAME_MESSAGE = "## 역이름을 입력하세요.";
    private static final String INPUT_SEQUENCE_MESSAGE = "## 순서를 입력하세요.";
    private static final String INPUT_LINE_NAME_FOR_REMOVING_SECTION_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";

    public static String inputValue(Scanner scanner) {
        System.out.println(INPUT_WANTED_FUNCTION_MESSAGE);
        try {
            return scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputValue(scanner);
        }
    }

    public static Station inputStation(Scanner scanner) {
        System.out.println(INPUT_WANTED_STATION_NAME_MESSAGE);
        try {
            return new Station(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputStation(scanner);
        }
    }

    public static String inputRemovingStationName(Scanner scanner) {
        System.out.println(INPUT_WANTED_DELETE_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static Line inputLine(Scanner scanner) {
        try {
            String lineName = inputLineName(scanner);
            Station upBoundStation = new Station(inputUpBoundStationName(scanner));
            Station downBoundStation = new Station(inputDownBoundStationName(scanner));
            return new Line(lineName, Arrays.asList(upBoundStation, downBoundStation));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLine(scanner);
        }
    }

    public static String inputLineName(Scanner scanner) {
        System.out.println(INPUT_WANTED_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    private static String inputUpBoundStationName(Scanner scanner) {
        System.out.println(INPUT_WANTED_UP_BOUND_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    private static String inputDownBoundStationName(Scanner scanner) {
        System.out.println(INPUT_WANTED_DOWN_BOUND_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputRemovingLineName(Scanner scanner) {
        System.out.println(INPUT_WANTED_DELETE_LINE_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputStationName(Scanner scanner) {
        System.out.println(INPUT_STATION_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputStationLocation(Scanner scanner) {
        System.out.println(INPUT_SEQUENCE_MESSAGE);
        return scanner.nextInt();
    }

    public static String inputLineNameForRemovingSection(Scanner scanner) {
        System.out.println(INPUT_LINE_NAME_FOR_REMOVING_SECTION_MESSAGE);
        return scanner.nextLine();
    }
}
