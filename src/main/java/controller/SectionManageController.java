package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import utils.ValidateUtils;
import view.SectionManageView;

public class SectionManageController {
    private static final String INPUT_ADD_SECTION = "1";
    private static final String INPUT_MESSAGE_LINE_NAME = "## 노선을 입력하세요.";
    private static final String INPUT_MESSAGE_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String INPUT_MESSAGE_POSITION = "## 순서를 입력하세요.";
    private static final String COMPLETE_ADD_SECTION = "[INFO] 구간이 등록되었습니다.";
    private static final String ERROR_NOT_EXIST_LINE = "\n[ERROR] 존재하지 않는 노선입니다.\n";
    private static final String ERROR_NOT_EXIST_STATION = "\n[ERROR] 존재하지 않는 역입니다.\n";
    private static final String ERROR_INPUT_ONLY_NUMBER = "\n[ERROR] 위치에 숫자만 입력해주세요.\n";
    private static final String ERROR_EXIST_STATION_IN_LINE = "\n[ERROR] 이미 노선에 존재하는 구간입니다.\n";
    private static final String ERROR_CAN_NOT_ADD_POSITION_AT =
            "\n[ERROR] 해당 위치에 구간을 추가 할 수 없습니다.\n";

    private SectionManageView view;

    public SectionManageController(SectionManageView view) {
        this.view = view;
    }

    public void processInput(String input) {
        if (input.equals(INPUT_ADD_SECTION)) {
            addSection();
        }
    }

    private void addSection() {
        String lineName = inputFromView(INPUT_MESSAGE_LINE_NAME);
        String stationName = inputFromView(INPUT_MESSAGE_STATION_NAME);
        String position = inputFromView(INPUT_MESSAGE_POSITION);

        if (validateAddSectionInputs(lineName, stationName, position)) {
            Line line = LineRepository.getLineByName(lineName);
            Station station = StationRepository.getStationByName(stationName);
            line.addStationAt(Integer.valueOf(position), station);

            view.printMessage(COMPLETE_ADD_SECTION);
        }
    }

    public boolean validateInput(String input) {
        return ValidateUtils.validateSectionInput(input);
    }

    public boolean validateAddSectionInputs(String lineName, String stationName, String position) {
        return validateLineName(lineName) && validateStationName(lineName, stationName)
                && validatePosition(lineName, position);
    }

    private boolean validateLineName(String lineName) {
        if (!LineRepository.isExistLine(lineName)) {
            view.printMessage(ERROR_NOT_EXIST_LINE);
            return false;
        }
        return true;
    }

    private boolean validateStationName(String lineName, String stationName) {
        if (!StationRepository.isExistStation(stationName)) {
            view.printMessage(ERROR_NOT_EXIST_STATION);
            return false;
        }

        Line line = LineRepository.getLineByName(lineName);
        Station station = StationRepository.getStationByName(stationName);
        if (line.contains(station)) {
            view.printMessage(ERROR_EXIST_STATION_IN_LINE);
            return false;
        }
        return true;
    }

    private boolean validatePosition(String lineName, String position) {
        if (!isNumeric(position)) {
            view.printMessage(ERROR_INPUT_ONLY_NUMBER);
            return false;
        }
        int pos = Integer.parseInt(position);
        int sectionLength = LineRepository.getLineByName(lineName).sections().size();
        if (pos > sectionLength + 1) {
            view.printMessage(ERROR_CAN_NOT_ADD_POSITION_AT);
            return false;
        }
        return true;
    }

    private boolean isNumeric(String s) {
        try {
            int num = Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private String inputFromView(String inputHint) {
        view.printMessage(inputHint);
        return view.input();
    }
}
