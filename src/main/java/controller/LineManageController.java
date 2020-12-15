package controller;

import java.util.Map;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import utils.ConstantsString;
import utils.ValidateUtils;
import view.LineManageView;

public class LineManageController {

    private LineManageView view;

    public LineManageController(LineManageView view) {
        this.view = view;
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateInput(input);
    }

    public void processInput(String input) {
        if (input.equals(ConstantsString.INPUT_ADD_LINE)) {
            addLine();
        }
        if (input.equals(ConstantsString.INPUT_REMOVE_LINE)) {
            removeLine();
        }
        if (input.equals(ConstantsString.INPUT_SHOW_LINES)) {
            showLines();
        }
    }

    private void addLine() {
        String lineName = inputFromView(ConstantsString.INPUT_MESSAGE_LINE_NAME);
        String upwardDestination = inputFromView(ConstantsString.INPUT_MESSAGE_UPWARD_DESTINATION);
        String downwardDestination =
                inputFromView(ConstantsString.INPUT_MESSAGE_DOWNWARD_DESTINATION);

        if (!validateAddLineInputs(lineName, upwardDestination, downwardDestination)) {
            return;
        }

        Line line = new Line(lineName);
        line.addStation(StationRepository.getStationByName(upwardDestination));
        line.addStation(StationRepository.getStationByName(downwardDestination));
        LineRepository.addLine(line);
        view.printMessage(ConstantsString.COMPLETE_ADD_LINE);
    }

    private boolean validateAddLineInputs(String lineName, String upwardDestination,
            String downwardDestination) {
        if (LineRepository.isExistLine(lineName)) {
            view.printMessage(ConstantsString.ERROR_EXIST_LINE);
            return false;
        }
        if (!ValidateUtils.validateLengthMoreThanTwo(lineName)) {
            view.printMessage(ConstantsString.ERROR_INPUT_MORE_THAN_TWO);
            return false;
        }
        if (!StationRepository.isExistStation(upwardDestination)
                || !StationRepository.isExistStation(downwardDestination)) {
            view.printMessage(ConstantsString.ERROR_NOT_EXIST_DESTINATION_STATION);
            return false;
        }
        return true;
    }

    private void removeLine() {
        String lineNameToDelete = inputFromView(ConstantsString.INPUT_MESSAGE_LINE_NAME_TO_DELETE);

        if (!LineRepository.isExistLine(lineNameToDelete)) {
            view.printMessage(ConstantsString.ERROR_NOT_EXIST_LINE_TO_DELETE);
            return;
        }

        LineRepository.deleteLineByName(lineNameToDelete);
        view.printMessage(ConstantsString.COMPLETE_REMOVE_LINE);
    }

    private void showLines() {
        Map<String, Line> map = LineRepository.lines();
        view.printMessage(ConstantsString.LINE_LIST);
        map.values().stream()
                .forEach(it -> view.printMessage(ConstantsString.INFO_PREFIX + it.getName()));
        view.printMessage("");
    }

    private String inputFromView(String inputHint) {
        view.printMessage(inputHint);
        return view.input();
    }
}
