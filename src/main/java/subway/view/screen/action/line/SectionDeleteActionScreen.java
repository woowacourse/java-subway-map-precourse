package subway.view.screen.action.line;

import subway.CategoryType;
import subway.line.dto.SectionDeleteRequestDto;
import subway.line.service.LineStationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class SectionDeleteActionScreen extends BaseActionScreen {

    public static final String DELETE_SECTION_LINE_INPUT_MESSAGE = "삭제할 구간의 노선을 입력하세요.";
    public static final String DELETE_SECTION_STATION_INPUT_MESSAGE = "삭제할 구간의 역을 입력하세요.";
    public static final String INSERT_INPUT_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    public SectionDeleteActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(DELETE_SECTION_LINE_INPUT_MESSAGE);
        String lineName = inputView.readCommand();

        OutputView.printTitle(DELETE_SECTION_STATION_INPUT_MESSAGE);
        String stationName = inputView.readCommand();

        LineStationService.deleteSection(new SectionDeleteRequestDto(lineName, stationName));
        OutputView.printlnResult(INSERT_INPUT_SUCCESS_MESSAGE);
    }
}
