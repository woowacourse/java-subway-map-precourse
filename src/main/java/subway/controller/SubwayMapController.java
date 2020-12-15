package subway.controller;

import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class SubwayMapController implements Controller {

    private final String TITLE = "지하철 노선도";
    private static final String TITLE_FOOTER = " 출력";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(TITLE);
        PrintUtils.printSubwayMap(LineService.findAllLine());
    }

    @Override
    public String getTitle() {
        return TITLE + TITLE_FOOTER;
    }
}
