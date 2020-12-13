package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineManagementController {

    private static LineManagementController instance;

    private LineManagementController() {
    }

    public static LineManagementController getInstance() {
        if (instance == null) {
            instance = new LineManagementController();
        }
        return instance;
    }

    public void addLine(String name, String start, String end) {
        LineRepository.addLine(new Line(name, start, end));
    }

    public void deleteLine(String name) {
        LineRepository.deleteLineByName(name);
    }
}
