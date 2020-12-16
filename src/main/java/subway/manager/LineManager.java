package subway.manager;
/*
 * InputLineManager
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.Constants;
import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class LineManager {
    private enum Menu {
        REGISTER("1", LineManager::register),
        DELETE("2", LineManager::delete),
        INQUIRY("3", OutputView::printLine),
        BACK("B", () -> {});

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

    public static void selectMenu() {
        try {
            Menu.execute(InputView.inputLineMenu());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    public static void register() {
        try {
            Line line = new Line(new LineName(InputView.inputLineToRegister()));
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

    private static void registerStartStation(Line line) {
        try {
            Station station = new Station(
                    new StationName(InputView.inputStartStationToEnroll()));
            if (!StationRepository.stations().contains(station)) {
                throw new IllegalArgumentException(Constants.NOTHING_TRY_AGAIN);
            }
            registerEndStation(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerStartStation(line);
        }
    }

    private static void registerEndStation(Line line, Station startStation) {
        try {
            Station endStation = new Station(new StationName(InputView.inputEndStationToEnroll()));
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

    public static void delete() {
        try {
            if (!LineRepository.deleteLineByName(new LineName(InputView.inputLineToDelete()))) {
                throw new IllegalArgumentException(Constants.NOTHING_TO_DELETE_TRY_AGAIN);
            }
            System.out.println(Constants.LINE_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
