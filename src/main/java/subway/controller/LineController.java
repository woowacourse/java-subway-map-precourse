package subway.controller;

import java.util.List;
import subway.service.SubwayService;

public class LineController {
    private final SubwayService subwayService;

    public LineController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    public void addLines(List<String> lines) {
        subwayService.addAll(lines);
    }
}
