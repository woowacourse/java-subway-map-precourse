package subway.controller.station;

import subway.controller.Controller;
import subway.service.StationService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class StationInsertController implements Controller {

    private static final String TITLE = "역 등록";
    private static final String INSERT_DESCRIPTION = "등록할 역 이름을 입력하세요.";
    private static final String INSERT_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(INSERT_DESCRIPTION);
        String input = inputUtils.getNextLine();

        boolean isAdded = StationService.addStation(input);
        if(isAdded) {
            PrintUtils.printInfo(INSERT_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
