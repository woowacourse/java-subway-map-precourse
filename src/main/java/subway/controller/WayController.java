package subway.controller;

import subway.domain.*;
import subway.view.*;

public class WayController {
    private static InputView inputView;

    public static boolean doAction(DetailActions detailActions) {
        WayController.inputView = SubwayController.inputView;
        try {
            WayActions.findAction(detailActions).run();
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    public static void enrollWay() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveNotice(DetailActions.ENROLL, MainActions.LINE));
        Line enrolledLine = LineRepository.findLineByName(LineValidator.checkEnrolledLine(inputView.receiveActionInfo()));

        ActionOutputView.printFormat(ActionOutputView.makeReceiveNotice(DetailActions.ENROLL, MainActions.STATION));
        Station enrolledStation = StationValidator.checkUnrolledStationInLine(enrolledLine, StationRepository.findStationByName(StationValidator.checkEnrolledStation(inputView.receiveActionInfo())));

        ActionOutputView.printFormat(ActionOutputView.makeOrderNotice());
        Integer order = OrderValidator.makeValidOrder(inputView.receiveActionInfo(), SubwayRepository.subway().get(enrolledLine).size());

        SubwayRepository.addLineStationSpecificPlace(enrolledLine, enrolledStation, order);

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.ENROLL, MainActions.WAY));
    }

    public static void removeWay() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveNotice(DetailActions.REMOVE, MainActions.LINE));
        Line selectedLine = LineValidator.checkPossibleToRemove(LineRepository.findLineByName(LineValidator.checkEnrolledLine(inputView.receiveActionInfo())));

        ActionOutputView.printFormat(ActionOutputView.makeReceiveNotice(DetailActions.REMOVE, MainActions.STATION));
        Station selectedStation = StationValidator.checkEnrolledStationInLine(selectedLine, StationRepository.findStationByName(inputView.receiveActionInfo()));

        SubwayRepository.deleteStationFromLine(selectedLine, selectedStation);

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.REMOVE, MainActions.WAY));
    }
}
