package subway.controller.line;

import subway.controller.Controller;
import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class LineDeleteController implements Controller {

    private final String TITLE = "노선 삭제";
    private static final String DELETE_DESCRIPTION = "삭제할 노선 이름을 입력하세요.";
    private static final String DELETE_SUCCESS_MESSAGE = "노선이 삭제되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        PrintUtils.printTitleOrDescription(DELETE_DESCRIPTION);
        String input = inputUtils.getNextLine();

        boolean isDeleted = LineService.deleteLine(input);
        if(isDeleted) {
            PrintUtils.printInfo(DELETE_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
