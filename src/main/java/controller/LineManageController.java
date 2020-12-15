package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import utils.ValidateUtils;
import view.LineManageView;

public class LineManageController {
    private static final String INPUT_ADD_LINE = "1";
    private static final String INPUT_MESSAGE_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_MESSAGE_UPWARD_DESTINATION = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String INPUT_MESSAGE_DOWNWARD_DESTINATION = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String COMPLETE_ADD_LINE = "\n[INFO] 지하철 노선이 등록되었습니다.\n";
    private static final String ERROR_EXIST_LINE = "\n[ERROR] 이미 존재하는 노선입니다.\n";
    private static final String ERROR_NOT_EXIST_STATION = "\n[ERROR] 상행 종점역 또는 하행 종점역이 존재하지 않니다.\n";
    private static final String ERROR_INPUT_MORE_THAN_TWO = "\n[ERROR] 2글자 이상 입력해주세요.\n";
    private LineManageView view;

    public LineManageController(LineManageView view) {
        this.view = view;
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateInput(input);
    }

    public void processInput(String input) {
        if (input.equals(INPUT_ADD_LINE)) {
            addLine();
        }
    }

    public void addLine() {
        String lineName = inputFromView(INPUT_MESSAGE_LINE_NAME);
        String upwardDestination = inputFromView(INPUT_MESSAGE_UPWARD_DESTINATION);
        String downwardDestination = inputFromView(INPUT_MESSAGE_DOWNWARD_DESTINATION);

        if (!validateAddLineInputs(lineName, upwardDestination, downwardDestination)) {
            return;
        }

        Line line = new Line(lineName);
        line.addStation(StationRepository.getStationByName(upwardDestination));
        line.addStation(StationRepository.getStationByName(downwardDestination));
        LineRepository.addLine(line);

        view.printMessage(COMPLETE_ADD_LINE);
    }

    public boolean validateAddLineInputs(String lineName, String upwardDestination,
            String downwardDestination) {
        if (LineRepository.isExistLine(lineName)) {
            view.printMessage(ERROR_EXIST_LINE);
            return false;
        }
        if (!ValidateUtils.validateLengthMoreThanTwo(lineName)) {
            view.printMessage(ERROR_INPUT_MORE_THAN_TWO);
            return false;
        }
        if (!StationRepository.isExistStation(upwardDestination)
                || !StationRepository.isExistStation(downwardDestination)) {
            view.printMessage(ERROR_NOT_EXIST_STATION);
            return false;
        }
        return true;
    }

    public String inputFromView(String inputHint) {
        view.printMessage(inputHint);
        return view.input();
    }
}
