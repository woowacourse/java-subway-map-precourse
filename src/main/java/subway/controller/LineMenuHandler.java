package subway.controller;

import subway.domain.*;
import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static subway.util.TextConstant.*;

public class LineMenuHandler {
    public static void addLine() {
        OutputView.showRequestInputForAddMessage(ROUTE);
        //todo : validate Util로 검증로직들 뽑아서 line 이름에 대해 검증해야 함
        String lineName = InputView.nextLine();
        if (LineRepository.isPresentLine(lineName)) {
            throw new SubwayException(ERR_ALREADY_ADD_LINE_NAME_MSG);
        }
        if (lineName.length() < NAME_MIN_LENGTH) {
            throw new SubwayException(ERR_SHORT_NAME_MSG);
        }
        if (!lineName.endsWith(LINE)) {
            throw new SubwayException(ERR_WRONG_LINE_NAME_SUFFIX);
        }
        OutputView.showRequestInputForAddMessage(UPLINE_TERMINAL_STATION);
        Station uplineTerminalStation = StationRepository.findStationByName(InputView.nextLine().trim());

        OutputView.showRequestInputForAddMessage(DOWNLINE_TERMINAL_STATION);
        Station downlineTerminalStation = StationRepository.findStationByName(InputView.nextLine().trim());

        LineRepository.addLine(LineFactory.makeLine(lineName, uplineTerminalStation, downlineTerminalStation));
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
    }
}
