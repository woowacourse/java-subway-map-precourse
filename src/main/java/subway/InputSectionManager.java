package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class InputSectionManager implements InputManager {
    private static final String SECTION_MAIN_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\n" +
            "B. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_LINE = "## 노선을 입력하세요.";
    private static final String SECTION_ENROLLED = "\n[INFO] 구간이 등록되었습니다.\n";
    private static final String LINE_NOTHING_TRY_AGAIN = "[ERROR] 해당 노선이 없습니다.";
    private static final String SECTION_MENU = "3";
    private static final String INPUT_STATION = "## 역이름을 입력하세요.";
    private static final String NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN = "[ERROR] 해당 역이 없거나" +
            " 이미 노선에 등록되어 있습니다.";
    public static final String INPUT_ORDER = "## 순서를 입력하세요.";
    public static final String INDEX_OUT_OF_BOUNDS_TRY_AGAIN = "[ERROR] 인덱스가 초과되었습니다.";
    public static final String INPUT_LINE_OF_SECTION_TO_DELETE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String SECTION_DELETED = "\n[INFO] 구간이 삭제되었습니다.\n";
    public static final String INPUT_STATION_OF_SECTION_TO_ENROLL = "## 삭제할 구간의 역을 입력하세요.";
    public static final String STATION_NOTHING_OR_LINE_LENGTH_LIMIT_TRY_AGAIN = "[ERROR] " +
            "해당 역이 없거나 현재 노선의 길이가 2이하여서 삭제 할 수 없습니다.";
    public static final int LINE_MIN_LENGTH = 2;

    private Scanner scanner;

    private enum Menu {
        REGISTER("1", ((InputSectionManager) SubwayManager.getMenus(SECTION_MENU))::register),
        DELETE("2", ((InputSectionManager) SubwayManager.getMenus(SECTION_MENU))::delete);
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

    public InputSectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(SECTION_MAIN_MENU);
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
            System.out.println(INPUT_LINE);
            Line line = new Line(new LineName(scanner.next()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(LINE_NOTHING_TRY_AGAIN);
            }
            registerStationInSection(line);
            System.out.println(SECTION_ENROLLED);
        } catch (IllegalArgumentException
                e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private void registerStationInSection(Line line) {
        try {
            System.out.println(INPUT_STATION);
            Station station = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(station)
                    || LineRepository.containsStationOfLine(line, station)) {
                throw new IllegalArgumentException(NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN);
            }
            registerOrderInSection(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStationInSection(line);
        }
    }

    private void registerOrderInSection(Line line, Station station) {
        try {
            System.out.println(INPUT_ORDER);
            PositiveNumber orderNumber = new PositiveNumber(scanner.next());
            PositiveNumber lineSize = new PositiveNumber(LineRepository.getLineSize(line));
            if (orderNumber.compareTo(lineSize) > 0) {
                throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS_TRY_AGAIN);
            }
            station.setRegister(true);
            LineRepository.addSection(line, station, orderNumber.getNumber() - 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerOrderInSection(line, station);
        }
    }

    @Override
    public void delete() {
        try {
            System.out.println(INPUT_LINE_OF_SECTION_TO_DELETE);
            Line line = new Line(new LineName(scanner.next()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(LINE_NOTHING_TRY_AGAIN);
            }
            deleteStationOfSection(line);
            System.out.println(SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

    private void deleteStationOfSection(Line line) {
        try {
            System.out.println(INPUT_STATION_OF_SECTION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (!LineRepository.containsStationOfLine(line, station)
                    || LineRepository.getLineSize(line) <= LINE_MIN_LENGTH) {
                throw new IllegalArgumentException(STATION_NOTHING_OR_LINE_LENGTH_LIMIT_TRY_AGAIN);
            }
            LineRepository.deleteSection(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deleteStationOfSection(line);
        }
    }
}
