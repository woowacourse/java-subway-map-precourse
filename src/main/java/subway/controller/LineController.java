package subway.controller;

import java.util.List;
import subway.domain.constants.LineCommand;
import subway.service.RouteService;
import subway.service.SubwayService;
import subway.view.LineView;

public class LineController {
    private final LineView lineView;
    private final SubwayService subwayService;
    private final RouteService routeService;

    public LineController(LineView lineView, SubwayService subwayService, RouteService routeService) {
        this.lineView = lineView;
        this.subwayService = subwayService;
        this.routeService = routeService;
    }

    public void run() {
        lineView.printFunctions();
        LineCommand function = lineView.enterFunction();
        if (function.equals(LineCommand.ADD)) {
            addLine();
        }
        if (function.equals(LineCommand.DELETE)) {
            deleteLine();
        }
        if (function.equals(LineCommand.GET)) {
            getLines();
        }
    }

    public void addLines(List<String> lines) {
        subwayService.addAll(lines);
    }

    private void addLine() {
        String name = lineView.enterLineNameToAdd();
        String head = lineView.enterHeadStation();
        String tail = lineView.enterTailStation();
        routeService.addRoute(name, head, tail);
        subwayService.add(name);
        lineView.printAddResult();
    }

    private void deleteLine() {
        String name = lineView.enterLineNameToDelete();
        subwayService.delete(name);
        lineView.printDeleteResult();
    }

    private void getLines() {
        lineView.printAllLines(subwayService.getAll());
    }
}
