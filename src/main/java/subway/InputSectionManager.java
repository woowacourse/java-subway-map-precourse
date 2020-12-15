package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class InputSectionManager implements InputManager {
    private Scanner scanner;

    private enum Menu {
        REGISTER("1", ((InputSectionManager) SubwayManager.getMenus(Constants.SECTION_MENU))::register),
        DELETE("2", ((InputSectionManager) SubwayManager.getMenus(Constants.SECTION_MENU))::delete),
        BACK("B", System.out::println);

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
                    .orElseThrow(() -> new IllegalArgumentException(Constants.WRONG_STATE_TRY_AGAIN))
                    .runnable.run();
        }
    }

    public InputSectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(Constants.SECTION_MAIN_MENU);
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
            System.out.println(Constants.INPUT_LINE);
            Line line = new Line(new LineName(scanner.next()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(Constants.LINE_NOTHING_TRY_AGAIN);
            }
            registerStationInSection(line);
            System.out.println(Constants.SECTION_ENROLLED);
        } catch (IllegalArgumentException
                e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private void registerStationInSection(Line line) {
        try {
            System.out.println(Constants.INPUT_STATION);
            Station station = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(station)
                    || LineRepository.containsStationOfLine(line, station)) {
                throw new IllegalArgumentException(Constants.NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN);
            }
            registerOrderInSection(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStationInSection(line);
        }
    }

    private void registerOrderInSection(Line line, Station station) {
        try {
            System.out.println(Constants.INPUT_ORDER);
            PositiveNumber orderNumber = new PositiveNumber(scanner.next());
            PositiveNumber lineSize = new PositiveNumber(LineRepository.getLineSize(line));
            if (orderNumber.compareTo(lineSize) > 0) {
                throw new IllegalArgumentException(Constants.INDEX_OUT_OF_BOUNDS_TRY_AGAIN);
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
            System.out.println(Constants.INPUT_LINE_OF_SECTION_TO_DELETE);
            Line line = new Line(new LineName(scanner.next()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(Constants.LINE_NOTHING_TRY_AGAIN);
            }
            deleteStationOfSection(line);
            System.out.println(Constants.SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

    private void deleteStationOfSection(Line line) {
        try {
            System.out.println(Constants.INPUT_STATION_OF_SECTION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (!LineRepository.containsStationOfLine(line, station)
                    || LineRepository.getLineSize(line) <= Constants.LINE_MIN_LENGTH) {
                throw new IllegalArgumentException(Constants.STATION_NOTHING_OR_LINE_LENGTH_LIMIT_TRY_AGAIN);
            }
            LineRepository.deleteSection(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deleteStationOfSection(line);
        }
    }
}
