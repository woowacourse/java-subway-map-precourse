package subway.controller.section;

import subway.controller.Controller;
import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class SectionDeleteController implements Controller {

    private final String TITLE = "구간 삭제";
    private static final String LINE_NAME_DESCRIPTION = "삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_NAME_DESCRIPTION = "삭제할 구간의 역을 입력하세요.";
    private static final String DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(LINE_NAME_DESCRIPTION);
        String lineName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(STATION_NAME_DESCRIPTION);
        String stationName = inputUtils.getNextLine();

        boolean isDeleted = LineService.deleteStationInLine(lineName, stationName);
        if(isDeleted) {
            PrintUtils.printInfo(DELETE_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
