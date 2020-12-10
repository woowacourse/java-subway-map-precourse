package subway.view.screen.action.line;

import subway.CategoryType;
import subway.line.dto.SectionInsertRequestDto;
import subway.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.action.BaseActionScreen;

public class SectionInsertActionScreen extends BaseActionScreen {

    public static final String INSERT_SECTION_LINE_INPUT_MESSAGE = "노선을 입력하세요.";
    public static final String DELETE_SECTION_STATION_INPUT_MESSAGE = "역이름을 입력하세요.";
    public static final String DELETE_SECTION_ORDER_INPUT_MESSAGE = "순서를 입력하세요.";
    public static final String INSERT_INPUT_SUCCESS_MESSAGE = "구간이 등록되었습니다.";

    public SectionInsertActionScreen(CategoryType selectedCategoryType) {
        super(selectedCategoryType);
    }

    @Override
    public void visualize() {}

    @Override
    protected void action(InputView inputView) {
        OutputView.printTitle(INSERT_SECTION_LINE_INPUT_MESSAGE);
        String lineName = inputView.readCommand();

        OutputView.printTitle(DELETE_SECTION_STATION_INPUT_MESSAGE);
        String stationName = inputView.readCommand();

        OutputView.printTitle(DELETE_SECTION_ORDER_INPUT_MESSAGE);
        int indexToInsert = inputView.readLineIndex();

        LineService.addSection(new SectionInsertRequestDto(lineName, indexToInsert, stationName));
        OutputView.printlnResult(INSERT_INPUT_SUCCESS_MESSAGE);
    }
}
