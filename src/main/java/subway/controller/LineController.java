package subway.controller;

import subway.domain.*;
import subway.view.LineView;

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
        Name name = lineView.getLineNameToAdd();
        LineRepository.addLine(Line.create(name, getStartStation(), getEndStation()));
        lineView.announceAdditionSuccess();
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
        LineRepository.remove(getLineToDelete());
        lineView.announceDeletionSuccess();
    }

    private Line getLineToDelete() {
        Name name = lineView.getLineNameToDelete();
        return LineRepository.getByName(name);
    }

    public void printLineList() {
        lineView.printLineList(LineRepository.getLineNames());
    }
}
