package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class InputLineManager implements InputManager {
    private static final String LINE_MAIN_MENU = "## 노선 관리 화면\n1. 노선 등록\n" +
                                                    "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_LINE_TO_ENROLL = "## 등록할 노선 이름을 입력하세요.";
    private static final String DUPLICATED_TRY_AGAIN = "[ERROR] 중복됩니다.";
    private static final String INPUT_START_STATION_TO_ENROLL = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String LINE_MENU = "2";
    public static final String LINE_ENROLLED = "\n[INFO] 지하철 노선이 등록되었습니다.\n";
    public static final String NOTHING_TRY_AGAIN = "[ERROR] 해당 역이 없습니다.";
    public static final String NOTHING_OR_START_END_SAME_TRY_AGAIN = "[ERROR] 해당 역이 없거나 상행 종점, 하행 종점역이 같습니다.";
    public static final String INPUT_END_STATION_TO_ENROLL = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String INPUT_LINE_TO_DELETE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String NOTHING_TO_DELETE_TRY_AGAIN = "[ERROR] 삭제할 노선이 없습니다.";
    public static final String LINE_DELETED = "\n[INFO] 지하철 노선이 삭제되었습니다.\n";

    private Scanner scanner;

    private enum Menu {
        REGISTER("1", ((InputLineManager) SubwayManager.getMenus(LINE_MENU))::register),
        DELETE("2", ((InputLineManager) SubwayManager.getMenus(LINE_MENU))::delete),
        INQUIRY("3", LineRepository::printLine);
//        BACK("B");

        private final String name;
        private final Runnable runnable;

        Menu(String name, Runnable runnable) {
            this.name = name;
            this.runnable = runnable;
        }

        public static void execute(String input) {
            Arrays.stream(values())
                    .filter(value -> value.name.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_STATE_TRY_AGAIN))
                    .runnable.run();
        }
    }

    public InputLineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(LINE_MAIN_MENU);
            String state = scanner.next();
            Menu.execute(state);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    @Override
    public void register() {
        try {
            System.out.println(INPUT_LINE_TO_ENROLL);
            Line line = new Line(new LineName(scanner.next()));
            if (LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(DUPLICATED_TRY_AGAIN);
            }
            LineRepository.addLine(line);
            registerStartStation(line);
            System.out.println(LINE_ENROLLED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private void registerStartStation(Line line) {
        try {
            System.out.println(INPUT_START_STATION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(station)) {
                throw new IllegalArgumentException(NOTHING_TRY_AGAIN);
            }
            registerEndStation(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStartStation(line);
        }
    }

    private void registerEndStation(Line line, Station startStation) {
        try {
            System.out.println(INPUT_END_STATION_TO_ENROLL);
            Station endStation = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(endStation)
                    || startStation.equals(endStation)) {
                throw new IllegalArgumentException(NOTHING_OR_START_END_SAME_TRY_AGAIN);
            }
            line.addStations(startStation);
            line.addStations(endStation);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerEndStation(line, startStation);
        }
    }

    @Override
    public void delete() {
        try {
            System.out.println(INPUT_LINE_TO_DELETE);
            String lineToDelete = scanner.next();
            if (!LineRepository.deleteLineByName(new LineName(lineToDelete))) {
                throw new IllegalArgumentException(NOTHING_TO_DELETE_TRY_AGAIN);
            }
            System.out.println(LINE_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
