package subway.controller.line;

import subway.controller.Controller;
import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class LineSelectController implements Controller {

    private final String TITLE = "노선 조회";
    private final String LIST_DESCRIPTION = "노선 목록";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(LIST_DESCRIPTION);
        LineService.findAllLine().forEach(s -> PrintUtils.printSerialInfo(s.getName()));
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
