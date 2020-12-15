package subway.controller.station;

import java.util.List;
import subway.controller.Controller;
import subway.domain.Station;
import subway.service.StationService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class StationSelectController implements Controller {

    private final String TITLE = "역 조회";
    private final String LIST_DESCRIPTION = "역 목록";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(LIST_DESCRIPTION);
        StationService.findAllStation().forEach(s -> PrintUtils.printSerialInfo(s.getName()));
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
