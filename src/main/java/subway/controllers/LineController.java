package subway.controllers;

import contants.ExceptionMessage;
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
            deleteLine();
        }
        if (LineMenu.THIRD.getUserInput().equals(selection)) {
            printLines();
        }
        if (LineMenu.BACK.getUserInput().equals(selection)) {
            goBackToMain();
        }
    }

    private static void goBackToMain() {
        MainController.run();
    }

    private static void printLines() {
        OutputView.printLookupLines(LineRepository.lines().stream()
                .map(station -> station.getName()).collect(Collectors.toList())
        );
    }

    private static void deleteLine() {
        OutputView.printAskDeleteLineMessage();
        String deletingLineName = InputView.read();
        validateDeletionLine(deletingLineName);
        SectionRepository.deleteSection(LineRepository.get(deletingLineName));
        LineRepository.deleteLineByName(deletingLineName);
        OutputView.finishedDeletingLine();
    }

    private static void validateDeletionLine(String deletingLineName) {
        if (!LineRepository.has(deletingLineName)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_DOES_NOT_EXIST.toString());
        }
    }

    private static void registerLine() {
        List<String> inputs = new ArrayList<>();
        for (String message : LineMenu.getFollowingInputMessage()) {
            OutputView.print(message);
            inputs.add(InputView.read());
        }
        validateLineDuplication(inputs.get(0));
        LineRepository.addLine(LineMaker.make(inputs.get(0)));
        addStationsToStationRepository(inputs.get(1), inputs.get(2));
        // TODO : sectioncontroller한테 넘겨줘도 될 듯
        addToSection(LineRepository.get(inputs.get(0)), StationRepository.get(inputs.get(1)), StationRepository.get(inputs.get(2)));
        OutputView.printFinishedAddingLine();
    }

    private static void validateLineDuplication(String lineName) {
        if (LineRepository.has(lineName)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_EXIST.toString());
        }
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
