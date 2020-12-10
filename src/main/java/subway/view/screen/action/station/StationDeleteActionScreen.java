package subway.view.screen.action.station;

import subway.CategoryType;
import subway.station.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class StationDeleteActionScreen extends BaseActionScreen {

    public static final String DELETE_INPUT_MESSAGE = "삭제할 역 이름을 입력하세요.";
    public static final String DELETE_INPUT_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public StationDeleteActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(DELETE_INPUT_MESSAGE);
        String stationName = inputView.readCommand();
        StationService.deleteByName(stationName);
        OutputView.printlnResult(DELETE_INPUT_SUCCESS_MESSAGE);
    }
}
