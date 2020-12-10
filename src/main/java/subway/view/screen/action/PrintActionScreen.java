package subway.view.screen.action;

import subway.line.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Screen;
import subway.view.screen.ScreenManager;

public class PrintActionScreen implements Screen {

    public static final String SUBWAY_WAY_MESSAGE = "지하철 노선도";

    @Override
    public void visualize() {
        OutputView.printTitle(SUBWAY_WAY_MESSAGE);
    }

    @Override
    public void logic(InputView inputView) {
        LineService.findAll().forEach(lineResponseDto -> {
            OutputView.printResult(lineResponseDto.getName());
            OutputView.printResult(COLUMN_LINE);

            lineResponseDto.getStations().forEach(
                stationResponseDto -> OutputView.printResult(stationResponseDto.getName()));

            OutputView.println();
        });

        ScreenManager.goToFirstScreen();
    }
}
