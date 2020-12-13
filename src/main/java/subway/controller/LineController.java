package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.service.LineService;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class LineController {
    private final LineService lineService;

    public LineController() {
        this.lineService = new LineService();
    }

    public boolean createSection(String name, String firstStation, String lastStation) {
        return lineService.addSection(name, firstStation, lastStation);
    }

    public boolean deleteLine(String name) {
        return lineService.deleteLine(name);
    }

    public List<Line> getLines() {
        return lineService.findAll();
    }
}
