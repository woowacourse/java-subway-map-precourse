package subway.controller;

import subway.domain.*;
import subway.domain.validator.LineValidator;
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
        Name newLineName = getLineNameToAdd();
        Station firstStation = getFirstStation();
        Station lastStation = getLastStation(firstStation);

        LineRepository.addLine(new Line(newLineName, firstStation, lastStation));
        lineView.announceAdditionSuccess();
    }

    private Name getLineNameToAdd() {
        try {
            Name name = lineView.getLineNameToAdd();
            LineValidator.checkNonExistingName(name);
            return name;
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getLineNameToAdd();
        }
    }

    private Station getFirstStation() {
        try {
            Name name = lineView.getFirstStationName();
            return StationRepository.getByName(name);
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getFirstStation();
        }
    }

    private Station getLastStation(Station firstStation) {
        try {
            Name name = lineView.getLastStationName();
            Station lastStation = StationRepository.getByName(name);
            LineValidator.checkEndStationsDifferent(firstStation, lastStation);
            return lastStation;
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getLastStation(firstStation);
        }
    }

    public void deleteLine() {
        Line line = getLineToDelete();
        LineRepository.remove(line);
        lineView.announceDeletionSuccess();
    }

    private Line getLineToDelete() {
        try {
            Name name = lineView.getLineNameToDelete();
            return LineRepository.getByName(name);
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getLineToDelete();
        }
    }

    public void printLineList() {
        OutputView.printMsg("## 노선 목록\n");
        LineRepository.getLineNames()
                .stream()
                .forEach(OutputView::printInfoMsg);
    }
}
