package subway.controller.line;

import java.util.ArrayList;
import java.util.List;
import subway.controller.Controller;
import subway.domain.Station;
import subway.service.LineService;
import subway.util.InputUtils;
import subway.util.PrintUtils;

public class LineInsertController implements Controller {

    private static final String TITLE = "노선 등록";
    private static final String NAME_DESCRIPTION = "등록할 노선의 이름을 입력하세요.";
    private static final String UPWARD_TERMINAL_DESCRIPTION = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNING_TERMINAL_DESCRIPTION = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String INSERT_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";

    @Override
    public void run(InputUtils inputUtils) {
        List<Station> stationList = new ArrayList<>();

        PrintUtils.printTitleOrDescription(NAME_DESCRIPTION);
        String lineName = inputUtils.getNextLine();
        PrintUtils.printTitleOrDescription(UPWARD_TERMINAL_DESCRIPTION);
        stationList.add(new Station(inputUtils.getNextLine()));
        PrintUtils.printTitleOrDescription(DOWNING_TERMINAL_DESCRIPTION);
        stationList.add(new Station(inputUtils.getNextLine()));

        boolean isAdded = LineService.addLine(lineName, stationList);
        if(isAdded) {
            PrintUtils.printInfo(INSERT_SUCCESS_MESSAGE);
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
