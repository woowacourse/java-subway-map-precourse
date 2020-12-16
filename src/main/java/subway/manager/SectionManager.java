package subway.manager;
/*
 * InputSectionManager
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

import java.util.Arrays;

public class SectionManager {
    private enum Menu {
        REGISTER("1", SectionManager::register),
        DELETE("2", SectionManager::delete),
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
            Menu.execute(InputView.inputSectionMenu());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    public static void register() {
        try {
            Line line = new Line(new LineName(InputView.inputSectionToRegister()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(Constants.LINE_NOTHING_TRY_AGAIN);
            }
            registerStationInSection(line);
            System.out.println(Constants.SECTION_ENROLLED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    private static void registerStationInSection(Line line) {
        try {
            Station station = new Station(
                    new StationName(InputView.inputStationInSectionToRegister()));
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

    private static void registerOrderInSection(Line line, Station station) {
        try {
            PositiveNumber orderNumber = new PositiveNumber(InputView.inputOrderInSectionToRegister());
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

    public static void delete() {
        try {
            Line line = new Line(new LineName(InputView.inputSectionToDelete()));
            if (!LineRepository.lines().contains(line)) {
                throw new IllegalArgumentException(Constants.LINE_NOTHING_TRY_AGAIN);
            }
            deleteStationInSection(line);
            System.out.println(Constants.SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

    private static void deleteStationInSection(Line line) {
        try {
            Station station = new Station(
                    new StationName(InputView.inputStationInSectionToDelete()));
            if (!LineRepository.containsStationOfLine(line, station)
                    || LineRepository.getLineSize(line) <= Constants.LINE_MIN_LENGTH) {
                throw new IllegalArgumentException(Constants.STATION_NOTHING_OR_LINE_LENGTH_LIMIT_TRY_AGAIN);
            }
            LineRepository.deleteSection(line, station);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deleteStationInSection(line);
        }
    }
}
