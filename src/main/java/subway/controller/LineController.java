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
        Name lineName = lineView.getLineNameToAdd();
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation();

        LineRepository.addLine(Line.create(lineName, firstStation, lastStation));
        lineView.announceAdditionSuccess();
    }

    private Station getFirstStation() {
        Name name = lineView.getFirstStationName();
        return StationRepository.getByName(name);
    }

    private Station getLastStation() {
        Name name = lineView.getLastStationName();
        return StationRepository.getByName(name);
    }

    public void deleteLine() {
        Line line = getLineToDelete();
        LineRepository.remove(line);
        lineView.announceDeletionSuccess();
    }

    private Line getLineToDelete() {
        Name name = lineView.getLineNameToDelete();
        return LineRepository.getByName(name);
    }

    public void printLineList() {
        OutputView.printMsg("## 노선 목록\n");
        LineRepository.getLineNames()
                .stream()
                .forEach(OutputView::printInfoMsg);
    }
}
