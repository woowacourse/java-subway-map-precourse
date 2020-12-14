package subway.controller;

import subway.domain.*;
import subway.view.LineView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    private static LineController lineController = null;

    private final LineView lineView;

    private LineController(Scanner scanner) {
        lineView = LineView.getInstance(scanner);
    }

    public static LineController getInstance(Scanner scanner) {
        if (lineController == null) {
            lineController = new LineController(scanner);
            return lineController;
        }
        return lineController;
    }

    public void addLine() {
        try {
            Name name = lineView.getLineNameToAdd();
            LineRepository.addLine(Line.create(name, getStartStation(), getEndStation()));
            lineView.announceAdditionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            addLine();
        }
    }

    private Station getStartStation() {
        return getStation(lineView.getStartStationName());
    }

    private Station getEndStation() {
        return getStation(lineView.getEndStationName());
    }

    private Station getStation(Name name) {
        return StationRepository.getByName(name);
    }

    public void deleteLine() {
        try {
            LineRepository.remove(getLineToDelete());
            lineView.announceDeletionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            deleteLine();
        }
    }

    private Line getLineToDelete() {
        return getLine(lineView.getLineNameToDelete());
    }

    private Line getLine(Name name) {
        return LineRepository.getByName(name);
    }

    public void printLineList() {
        lineView.printLineList(LineRepository.getLineNames());
        OutputView.printLineSeparator();
    }
}
