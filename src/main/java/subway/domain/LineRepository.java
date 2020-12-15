package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final String DIVIDING_LINE = "---";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean validateNewStationName(String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).validateNewName(name)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateNewLineName(String name) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public static void runLineMap() {
        OutputView.printLineMapTitle();
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            OutputView.printLineMapElement(line.getName());
            OutputView.printLineMapElement(DIVIDING_LINE);
            line.printLine();
            OutputView.printEmptyLine();
        }
    }

    public static void add(InputView inputView, String lineMessage, String stationMessage) {
        OutputView.printAddActionMessage(lineMessage);
        String newLineName = inputView.getInput();
        if (Line.validateAddLineName(newLineName, lineMessage)) {
            List<String> boundStations = Line.getValidBoundsStation(inputView, stationMessage);
            Line newLine = new Line(newLineName);
            newLine.setBoundStations(boundStations);
            LineRepository.addLine(newLine);
        }
        OutputView.printAddActionFinishMessage(lineMessage);
    }

    public static void delete(InputView inputView, String lineMessage) {
        OutputView.printDeleteActionMessage(lineMessage);
        String deleteLineName = inputView.getInput();
        if (Line.validateExistentLineName(deleteLineName, lineMessage)) {
            LineRepository.deleteLineByName(deleteLineName);
            OutputView.printDeleteActionFinishMessage(lineMessage);
        }
    }

    public static void printList(String lineMessage) {
        OutputView.printList(lineMessage, getLineNameList());
    }

    private static List<String> getLineNameList() {
        List<String> lineNames = new ArrayList<String>();
        for (int i = 0; i < lines.size(); i++) {
            lineNames.add(lines.get(i).getName());
        }
        return lineNames;
    }
}
