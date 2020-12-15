package subway;

import subway.domain.*;

import java.util.Arrays;
import java.util.Scanner;

public class InputLineManager implements InputManager {
    private Scanner scanner;

    private enum Menu {
        REGISTER("1", ((InputLineManager) SubwayManager.getMenus(Constants.LINE_MENU))::register),
        DELETE("2", ((InputLineManager) SubwayManager.getMenus(Constants.LINE_MENU))::delete),
        INQUIRY("3", LineRepository::printLine),
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

    public InputLineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(Constants.LINE_MAIN_MENU);
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
            System.out.println(Constants.INPUT_LINE_TO_ENROLL);
            Line line = new Line(new LineName(scanner.next()));
            if (LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(Constants.DUPLICATED_TRY_AGAIN);
            }
            LineRepository.addLine(line);
            registerStartStation(line);
            System.out.println(Constants.LINE_ENROLLED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private void registerStartStation(Line line) {
        try {
            System.out.println(Constants.INPUT_START_STATION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(station)) {
                throw new IllegalArgumentException(Constants.NOTHING_TRY_AGAIN);
            }
            registerEndStation(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStartStation(line);
        }
    }

    private void registerEndStation(Line line, Station startStation) {
        try {
            System.out.println(Constants.INPUT_END_STATION_TO_ENROLL);
            Station endStation = new Station(new StationName(scanner.next()));
            if (!StationRepository.stations().contains(endStation)
                    || startStation.equals(endStation)) {
                throw new IllegalArgumentException(Constants.NOTHING_OR_START_END_SAME_TRY_AGAIN);
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
            System.out.println(Constants.INPUT_LINE_TO_DELETE);
            String lineToDelete = scanner.next();
            if (!LineRepository.deleteLineByName(new LineName(lineToDelete))) {
                throw new IllegalArgumentException(Constants.NOTHING_TO_DELETE_TRY_AGAIN);
            }
            System.out.println(Constants.LINE_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
