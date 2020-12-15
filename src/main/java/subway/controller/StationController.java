package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.ActionOutputView;
import subway.view.OutputView;

public class StationController {
    private static InputView inputView;

    public static boolean doAction(DetailActions detailActions) {
        StationController.inputView = SubwayController.inputView;
        try {
            StationActions.findAction(detailActions).run();
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    public static void enrollStation() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveActionNotice(DetailActions.ENROLL, MainActions.STATION));

        StationRepository.addStation(new Station(StationValidator.checkUnrolledStation(NameValidator.makeName(inputView.receiveActionInfo()))));

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.ENROLL, MainActions.STATION));
    }

    public static void removeStation() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveActionNotice(DetailActions.REMOVE, MainActions.STATION));

        StationRepository.deleteStation(SubwayRepository.isStationNotInLine(StationValidator.checkEnrolledStation(inputView.receiveActionInfo())));

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.REMOVE, MainActions.STATION));
    }

    public static void researchStation() {
        ActionOutputView.printFormat(ActionOutputView.makeResearchResult(MainActions.STATION));
    }
}
