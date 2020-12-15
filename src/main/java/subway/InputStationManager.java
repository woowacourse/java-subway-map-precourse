package subway;
/*
 * InputStationManager
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.domain.Constants;
import subway.domain.Station;
import subway.domain.StationName;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class InputStationManager implements InputManager {
    private Scanner scanner;

    private enum Menu {
        REGISTER("1",
                    ((InputStationManager) SubwayManager.getMenus(Constants.STATION_MENU_NUMBER))::register),
        DELETE("2",
                    ((InputStationManager) SubwayManager.getMenus(Constants.STATION_MENU_NUMBER))::delete),
        INQUIRY("3", StationRepository::printStation),
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

    public InputStationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(Constants.STATION_MAIN_MENU);
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
            System.out.println(Constants.INPUT_STATION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (StationRepository.stations().contains(station)) {
                throw new IllegalArgumentException(Constants.DUPLICATED_TRY_AGAIN);
            }
            StationRepository.addStation(station);
            System.out.println(Constants.STATION_ENROLLED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    @Override
    public void delete() {
        try {
            System.out.println(Constants.INPUT_STATION_TO_DELETE);
            String stationToDelete = scanner.next();
            if (StationRepository.isRegisteredStation(new Station(new StationName(stationToDelete)))
                    || !StationRepository.deleteStation(stationToDelete)) {
                throw new IllegalArgumentException(Constants.NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN);
            }
            System.out.println(Constants.STATION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
