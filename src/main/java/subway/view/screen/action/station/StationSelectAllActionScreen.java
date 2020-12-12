package subway.view.screen.action.station;

import subway.CategoryType;
import subway.station.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class StationSelectAllActionScreen extends BaseActionScreen {

    public StationSelectAllActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(selectedCategoryType.getName() + SPACE + LIST_MESSAGE);
        StationService.findAll()
            .forEach(stationResponseDto -> OutputView.printResult(stationResponseDto.getName()));
    }
}
