package subway.manager;
/*
 * InputStationManager
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.Constants;
import subway.domain.Station;
import subway.domain.StationName;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class StationManager {
    private enum Menu {
        REGISTER("1", StationManager::register),
        DELETE("2", StationManager::delete),
        INQUIRY("3", OutputView::printStation),
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
            String state = InputView.inputStationMenu();
            Menu.execute(state);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    public static void register() {
        try {
            Station station = new Station(new StationName(InputView.inputStationToRegister()));
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

    public static void delete() {
        try {
            if (StationRepository.isRegisteredStation(
                                    new Station(new StationName(InputView.inputStationToDelete())))
                    || !StationRepository.deleteStation(InputView.inputStationToDelete())) {
                throw new IllegalArgumentException(Constants.NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN);
            }
            System.out.println(Constants.STATION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
