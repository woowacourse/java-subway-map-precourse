package subway.view.screen.action.line;

import subway.CategoryType;
import subway.line.dto.LineRequestDto;
import subway.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class LineInsertActionScreen extends BaseActionScreen {

    public static final String SAVE_INPUT_MESSAGE = "등록할 노선 이름을 입력하세요.";
    public static final String UPSTREAM_INPUT_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String DOWNSTREAM_INPUT_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";

    public LineInsertActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(SAVE_INPUT_MESSAGE);
        String lineName = inputView.readCommand();

        OutputView.printTitle(UPSTREAM_INPUT_MESSAGE);
        String upstreamStationName = inputView.readCommand();

        OutputView.printTitle(DOWNSTREAM_INPUT_MESSAGE);
        String downstreamStationName = inputView.readCommand();

        LineService.save(new LineRequestDto(lineName, upstreamStationName, downstreamStationName));
    }
}
