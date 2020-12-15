package subway.controller.station;

import subway.controller.Controller;
import subway.service.StationService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class StationDeleteController implements Controller {

    private final String TITLE = "역 삭제";
    private static final String DELETE_DESCRIPTION = "삭제할 역 이름을 입력하세요.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(DELETE_DESCRIPTION);
        String input = inputUtils.getNextLine();

        boolean isDeleted = StationService.deleteStation(input);
        if(isDeleted) {
            PrintUtils.printInfo(DELETE_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
