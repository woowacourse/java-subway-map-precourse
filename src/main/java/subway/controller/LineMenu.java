package subway.controller;

import subway.domain.LineManager;
import subway.domain.StationManager;
import subway.view.PrintInfo;
import subway.view.Error;

import java.util.Scanner;

public class LineMenu extends Menu {
    public LineMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void info() {
        PrintInfo.manageLine();
    }

    @Override
    protected boolean functionOne() {
        return addLine();
    }

    private boolean addLine() {
        PrintInfo.inputAddLineName();
        String line = scanner.nextLine();
        if (LineManager.anyMatchLineName(line)) {
            return Error.alreadyExist();
        }
        return setFromAndTo(line);
    }

    private boolean setFromAndTo(String line) {
        PrintInfo.inputAddLineStartStation();
        String from = scanner.nextLine();
        if (!StationManager.containsName(from)) {
            return Error.notExist();
        }
        return setTo(line, from);
    }

    private boolean setTo(String line, String from) {
        PrintInfo.inputAddLineEndStation();
        String to = scanner.nextLine();
        if (!StationManager.containsName(to)) {
            return Error.notExist();
        }
        return createLine(line, from, to);
    }

    private boolean createLine(String line, String from, String to) {
        try {
            LineManager.addLine(line, StationManager.getByName(from), StationManager.getByName(to));
        } catch (Exception e) {
            return Error.createLine();
        }
        PrintInfo.addLineSuccess();
        return true;
    }
}
