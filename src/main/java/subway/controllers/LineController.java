package subway.controllers;

import contants.LineMenu;
import subway.domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LineController {
    public static void run() {
        OutputView.printLineMenu(LineMenu.getWholeMenu());
        selectMenu();
    }

    private static void selectMenu() {
        OutputView.printSelectFunction();
        String selection = InputView.selectFunction();
        if (LineMenu.FIRST.getUserInput().equals(selection)) {
            registerLine();
        }
        if (LineMenu.SECOND.getUserInput().equals(selection)) {
            OutputView.printAskAddStation();
            String stationName = InputView.readDeletingStationName();
            StationRepository.deleteStation(stationName);
        }
        if (LineMenu.THIRD.getUserInput().equals(selection)) {
            OutputView.printLookupStations(StationRepository.stations().stream()
                    .map(station -> station.getName()).collect(Collectors.toList())
            );
        }
        if (LineMenu.BACK.getUserInput().equals(selection)) {
            MainController.run();
        }
    }

    private static void registerLine() {
        List<String> inputs = new ArrayList<>();
        for (String message : LineMenu.getFollowingInputMessage()) {
            OutputView.print(message);
            inputs.add(InputView.read());
        }
        LineRepository.addLine(LineMaker.make(inputs.get(0)));
        addStationsToStationRepository(inputs.get(1), inputs.get(2));
        addToSection(LineRepository.get(inputs.get(0)), StationRepository.get(inputs.get(1)), StationRepository.get(inputs.get(2)));
    }

    private static void addToSection(Line line, Station upStation, Station downStation) {
        SectionRepository.addNewSection(line, upStation, downStation);
    }

    private static void addStationsToStationRepository(String upStation, String downStation) {
        if (!StationRepository.has(upStation)) {
            StationRepository.addStation(StationMaker.make(upStation));
        }
        if (!StationRepository.has(downStation)) {
            StationRepository.addStation(StationMaker.make(downStation));
        }
    }
}
