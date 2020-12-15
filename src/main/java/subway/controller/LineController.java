package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.ActionOutputView;
import subway.view.OutputView;

public class LineController {
    private static final String UP_LINE = "상행";
    private static final String DOWN_LINE = "하행";

    private static InputView inputView;

    public static boolean doAction(DetailActions detailActions) {
        LineController.inputView = SubwayController.inputView;
        try {
            LineActions.findAction(detailActions).run();
            return true;
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return false;
        }
    }

    public static void enrollLine() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveActionNotice(DetailActions.ENROLL, MainActions.LINE));
        String enrollingLine = LineValidator.checkUnrolledLine(NameValidator.makeName(inputView.receiveActionInfo()));

        ActionOutputView.printFormat(ActionOutputView.makeReceiveStartOrFinishStationNotice(UP_LINE));
        String startStation = StationValidator.checkEnrolledStation(inputView.receiveActionInfo());

        ActionOutputView.printFormat(ActionOutputView.makeReceiveStartOrFinishStationNotice(DOWN_LINE));
        String finishStation = StationValidator.checkEnrolledStation(inputView.receiveActionInfo());

        enrollToSubway(enrollingLine, startStation, finishStation);

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.ENROLL, MainActions.LINE));
    }

    private static void enrollToSubway(String enrollingLine, String startStation, String finishStation) {
        if (startStation.equals(finishStation)) {
            throw new IllegalArgumentException("상행역과 하행역이 같을 수 없습니다.");
        }

        LineRepository.addLine(new Line(enrollingLine));
        SubwayRepository.addLine(LineRepository.findLineByName(enrollingLine));
        SubwayRepository.addStationInLine(LineRepository.findLineByName(enrollingLine), StationRepository.findStationByName(startStation));
        SubwayRepository.addStationInLine(LineRepository.findLineByName(enrollingLine), StationRepository.findStationByName(finishStation));
    }

    public static void removeLine() {
        ActionOutputView.printFormat(ActionOutputView.makeReceiveActionNotice(DetailActions.REMOVE, MainActions.LINE));

        String deleteLineName = LineValidator.checkEnrolledLine(inputView.receiveActionInfo());
        SubwayRepository.deleteLine(deleteLineName);
        LineRepository.deleteLineByName(deleteLineName);

        ActionOutputView.printFormat(ActionOutputView.makeSuccessNotice(DetailActions.REMOVE, MainActions.LINE));
    }

    public static void researchLine() {
        ActionOutputView.printFormat(ActionOutputView.makeResearchResult(MainActions.LINE));
    }
}
