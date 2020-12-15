package subway.controller.section;

import subway.controller.Controller;
import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class SectionInsertController implements Controller {

    private static final String TITLE = "구간 등록";
    private static final String LINE_NAME_DESCRIPTION = "노선을 입력하세요.";
    private static final String STATION_NAME_DESCRIPTION = "역 이름을 입력하세요.";
    private static final String ORDER_DESCRIPTION = "순서를 입력하세요.(0이 첫번째, 1이 두번째...)";
    private static final String INSERT_SUCCESS_MESSAGE = "구간이 등록되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(LINE_NAME_DESCRIPTION);
        String lineName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(STATION_NAME_DESCRIPTION);
        String stationName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(ORDER_DESCRIPTION);
        int order = inputUtils.getNextInt();
        if(order == -1) {
            return;
        }

        boolean isAdded = LineService.addStationInLine(lineName, stationName, order);
        if(isAdded) {
            PrintUtils.printInfo(INSERT_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
