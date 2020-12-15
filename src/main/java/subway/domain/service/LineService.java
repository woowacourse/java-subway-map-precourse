package subway.domain.service;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.repository.LineRepository;

import utils.Category;
import utils.ScriptUtils;

public class LineService {

    public static void readLineList() {
        System.out.println(ScriptUtils.LINE_LIST);
        for (Line line : LineRepository.lines()) {
            System.out.println(ScriptUtils.INFO + line.getName());
        }
    }

    public static void createLine(String name, List<Station> terminalNames) {
        try {
            if (duplicateName(name)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_DUPLICATE(Category.LINE));
            }
        } catch (IllegalArgumentException e) {
            System.out.println();
            return;
        }
        Line line = new Line(name, terminalNames);
        LineRepository.addLine(line);
    }

    public static void deleteLine(String name) {
    }

    private static boolean duplicateName(String input) {
        boolean notDuplicate = LineRepository.findNoLine(input);
        if (notDuplicate) {
            return false;
        }
        return true;
    }
}
