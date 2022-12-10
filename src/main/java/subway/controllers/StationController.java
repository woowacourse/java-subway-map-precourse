package subway.controllers;

import contants.MainMenu;
import contants.StationMenu;
import subway.domain.StationMaker;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class StationController {
    public static void run(Scanner scanner) {
        OutputView.printStationMenu(StationMenu.getWholeMenu());
        selectMenu(scanner);
    }

    private static void selectMenu(Scanner scanner) {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction(scanner);
        if (StationMenu.FIRST.getUserInput().equals(selection)) {
            OutputView.printAskAddStation();
            StationRepository.addStation(StationMaker.make(InputView.readStationName(scanner)));
        }
        if (StationMenu.SECOND.getUserInput().equals(selection)) {

        }
        if (StationMenu.THIRD.getUserInput().equals(selection)) {

        }
        if (StationMenu.BACK.getUserInput().equals(selection)) {

        }
    }
}
