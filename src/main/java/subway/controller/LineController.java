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
        Name name = lineView.getStartStationName();
        return StationRepository.getByName(name);
    }

    private Station getEndStation() {
        Name name = lineView.getEndStationName();
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
        Name name = lineView.getLineNameToDelete();
        return LineRepository.getByName(name);
    }

    public void printLineList() {
        lineView.printLineList(LineRepository.getLineNames());
    }
}
