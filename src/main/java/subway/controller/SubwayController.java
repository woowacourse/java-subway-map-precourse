package subway.controller;

import subway.domain.*;
import subway.view.ActionOutputView;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    protected static InputView inputView;

    public SubwayController(InputView inputView) {
        SubwayController.inputView = inputView;
    }

    public void run() {
        InitSetting.initSetting();
        startSubway();
    }

    private void startSubway() {
        while (true) {
            OutputView.printMain();
            MainActions nowAction = receiveMainAction();
            if (nowAction.equals(MainActions.FINISH)) {
                break;
            }
            if (nowAction.equals(MainActions.SUBWAY)) {
                subwayAction();
                continue;
            }
            startMainAction(nowAction);
        }
    }

    private MainActions receiveMainAction() {
        try {
            return MainActions.haveNumber(inputView.receiveAction());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            OutputView.printOneLine();
            return receiveMainAction();
        }
    }

    private void startMainAction(MainActions mainActions) {
        while (true) {
            OutputView.printDetailAction(mainActions);
            DetailActions detailActions = receiveDetailAction(mainActions);
            if (detailActions.equals(DetailActions.BACK)) {
                break;
            }
            if (mainActions.act.apply(detailActions)) {
                break;
            }
        }
    }

    private static DetailActions receiveDetailAction(MainActions mainActions) {
        try {
            return DetailActions.haveNumber(inputView.receiveAction(), mainActions);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            OutputView.printOneLine();
            return receiveDetailAction(mainActions);
        }
    }

    public static void subwayAction() {
        ActionOutputView.printFormat(ActionOutputView.makeSubwayResult(SubwayRepository.subway()));
    }
}
