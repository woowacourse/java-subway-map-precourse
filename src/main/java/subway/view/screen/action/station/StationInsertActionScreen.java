package subway.view.screen.action.station;

import subway.CategoryType;
import subway.station.dto.StationRequestDto;
import subway.station.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class StationInsertActionScreen extends BaseActionScreen {

    public static final String SAVE_INPUT_MESSAGE = "등록할 역 이름을 입력하세요.";
    public static final String SAVE_INPUT_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";

    public StationInsertActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(SAVE_INPUT_MESSAGE);
        String stationName = inputView.readCommand();
        StationService.save(new StationRequestDto(stationName));
        OutputView.printlnResult(SAVE_INPUT_SUCCESS_MESSAGE);
    }
}
