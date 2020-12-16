package subway.controller;
/*
 * Subway
 *
 * version 1.0
 *
 * 2020.12.15
 *
 * Copyright (c) by Davinci.J
 */
import subway.Constants;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.manager.LineManager;
import subway.manager.SectionManager;
import subway.manager.StationManager;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;

public class Subway {
    static {
        StationRepository.init();
        LineRepository.init();
    }

    private enum Menu {
        STATION("1", StationManager::selectMenu),
        LINE("2", LineManager::selectMenu),
        SECTION("3", SectionManager::selectMenu),
        SUBWAY_LIST("4", OutputView::printLineAndStation),
        QUIT("Q", new Subway()::exit);

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

    public static void run() {
        try {
            String state = InputView.inputMainMenu();
            Menu.execute(state);
            if (!state.equals(Constants.APPLICATION_QUIT)) {
                run();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private void exit() {
        System.exit(0);
    }

}