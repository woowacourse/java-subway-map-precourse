package subway.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.nashorn.internal.ir.Terminal;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.repository.LineRepository;

import utils.Category;
import utils.InitUtils;
import utils.ScriptUtils;

public class LineService {

    private LineService() {
    }

    public static void init() {
        for (int i = 0; i < InitUtils.INIT_LINES.length; i++) {
            List<Station> terminals;
            String[] terminalNames = InitUtils.INIT_TERMINALS[i];
            terminals = Arrays.asList(
                StationService.readStation(terminalNames[0]),
                StationService.readStation(terminalNames[1])
            );
            createLine(InitUtils.INIT_LINES[i], terminals);
        }
    }

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
        try {
            if (!duplicateName(name)) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_NO(Category.LINE));
            }
        } catch (IllegalArgumentException e) {
            System.out.println();
            return;
        }
        LineRepository.deleteLineByName(name);
    }

    public static boolean duplicateName(String input) {
        boolean notDuplicate = LineRepository.findNoLine(input);
        if (notDuplicate) {
            return false;
        }
        return true;
    }

}
