package subway.controller.menuhandler;

import subway.domain.*;
import subway.util.ValidateUtil;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static subway.util.TextConstant.*;

public class LineMenuHandler {
    public static void addLine() {
        OutputView.showRequestInputForAddMessage(ROUTE);

        String lineName = ValidateUtil.validateLineName(InputView.nextLine());

        OutputView.showRequestInputForAddMessage(UPLINE_TERMINAL_STATION);
        Station startStation = StationRepository.findStationByName(InputView.nextLine().trim());

        OutputView.showRequestInputForAddMessage(DOWNLINE_TERMINAL_STATION);
        Station endStation = StationRepository.findStationByName(InputView.nextLine().trim());

        LineRepository.addLine(LineFactory.makeLine(lineName, startStation, endStation));
        OutputView.showCompleteMessage(ROUTE, ADD);
    }

    public static void deleteLine() {
        OutputView.showRequestInputForDeleteMessage(ROUTE);
        LineRepository.deleteLineByName(InputView.nextLine().trim());
        OutputView.showCompleteMessage(ROUTE, DELETE);
    }

    public static void showLine() {
        List<String> lineNames = LineRepository.getLineNames();
        if (lineNames.isEmpty()) {
            OutputView.showEmptyListMessage(ROUTE);
            return;
        }
        OutputView.showList(lineNames);
    }

    public static void back() {
        //just through
    }
}
