package subway.controller;

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

    public boolean createLine(String name) {
        return lineService.addLine(name);
    }

    public boolean createSection(String name, String firstStation, String lastStation) {
        return lineService.addSection(name, firstStation, lastStation);
    }
}
