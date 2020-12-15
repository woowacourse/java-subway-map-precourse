package subway.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import subway.controller.LineController;
import subway.domain.Line;
import subway.view.InputView;
import subway.view.OutputView;

public enum LineManagementScreen {
    REGISTER_LINE("1", (inputView) ->
    {
        String lineName = ((InputView) inputView).getName(OutputView.ORDER_TO_REGISTER_LINE);
        String upTrainLastStationName = inputView
            .getName(OutputView.ORDER_TO_REGISTER_UP_TRAIN_LAST_STATION);
        String downTrainLastStationName = inputView
            .getName(OutputView.ORDER_TO_REGISTER_DOWN_TRAIN_LAST_STATION);
        return LineController
            .registerLine(lineName, upTrainLastStationName, downTrainLastStationName);
    }),
    DELETE_LINE("2", (inputView) ->
    {
        String lineName = inputView.getName(OutputView.ORDER_TO_DELETE_LINE);
        return LineController.deleteLine(lineName);
    }),
    SEARCH_LINE("3", (inputView) ->
    {
        List<Line> lines = new ArrayList<>(LineController.searchLine().keySet());
        OutputView.print(OutputView.LINE_LIST);
        OutputView.printList(lines);
        return false;
    }),
    BACK("B", (inputView) -> false);

    private String feature;
    private Function<InputView, Boolean> function;

    LineManagementScreen(String feature, Function<InputView, Boolean> function) {
        this.feature = feature;
        this.function = function;
    }

    public static boolean run(InputView inputView, String command) {
        if (hasFeature(command)) {
            return Arrays.stream(values())
                .filter(lineManagementScreen -> lineManagementScreen.feature.equals(command))
                .findAny()
                .orElse(LineManagementScreen.BACK)
                .function.apply(inputView);
        }
        return true;
    }

    public static boolean hasFeature(String command) {
        return Arrays.stream(values())
            .anyMatch(lineManagementScreen -> lineManagementScreen.feature.equals(command));
    }

}

