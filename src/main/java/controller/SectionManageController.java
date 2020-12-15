package controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import utils.ConstantsString;
import utils.ValidateUtils;
import view.SectionManageView;

public class SectionManageController {

    private SectionManageView view;

    public SectionManageController(SectionManageView view) {
        this.view = view;
    }

    public void processInput(String input) {
        if (input.equals(ConstantsString.INPUT_ADD_SECTION)) {
            addSection();
        }
        if (input.equals(ConstantsString.INPUT_REMOVE_SECTION)) {
            removeSection();
        }
    }

    private void removeSection() {
        String lineNameToDelete = inputFromView(ConstantsString.INPUT_MESSAGE_LINE_NAME_TO_DELETE);
        String stationNameToDelete =
                inputFromView(ConstantsString.INPUT_MESSAGE_STATION_NAME_TO_DELETE);

        if (validateRemoveSectionInputs(lineNameToDelete, stationNameToDelete)) {
            Line line = LineRepository.getLineByName(lineNameToDelete);
            Station station = StationRepository.getStationByName(stationNameToDelete);
            line.removeStation(station);
            view.printMessage(ConstantsString.COMPLETE_REMOVE_SECTION);
        }
    }

    private boolean validateRemoveSectionInputs(String lineName, String stationName) {
        return validateLineName(lineName) && validateIsStationExistInLine(lineName, stationName)
                && validateSectionLength(lineName);
    }

    private boolean validateSectionLength(String lineName) {
        Line line = LineRepository.getLineByName(lineName);
        if (line.sections().size() <= 2) {
            view.printMessage(ConstantsString.ERROR_SECTION_LESS_THAN_TWO);
            return false;
        }
        return true;
    }

    private boolean validateIsStationExistInLine(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        Station station = StationRepository.getStationByName(stationName);
        if (!line.contains(station)) {
            view.printMessage(ConstantsString.ERROR_NOT_EXIST_STATION_IN_LINE);
            return false;
        }
        return true;
    }

    private void addSection() {
        String lineName = inputFromView(ConstantsString.INPUT_MESSAGE_LINE_NAME);
        String stationName = inputFromView(ConstantsString.INPUT_MESSAGE_STATION_NAME);
        String position = inputFromView(ConstantsString.INPUT_MESSAGE_POSITION);

        if (validateAddSectionInputs(lineName, stationName, position)) {
            Line line = LineRepository.getLineByName(lineName);
            Station station = StationRepository.getStationByName(stationName);
            line.addStationAt(Integer.valueOf(position), station);

            view.printMessage(ConstantsString.COMPLETE_ADD_SECTION);
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
            view.printMessage(ConstantsString.ERROR_NOT_EXIST_LINE);
            return false;
        }
        return true;
    }

    private boolean validateStationName(String lineName, String stationName) {
        if (!StationRepository.isExistStation(stationName)) {
            view.printMessage(ConstantsString.ERROR_NOT_EXIST_STATION);
            return false;
        }

        Line line = LineRepository.getLineByName(lineName);
        Station station = StationRepository.getStationByName(stationName);
        if (line.contains(station)) {
            view.printMessage(ConstantsString.ERROR_EXIST_STATION_IN_LINE);
            return false;
        }
        return true;
    }

    private boolean validatePosition(String lineName, String position) {
        if (!isNumeric(position)) {
            view.printMessage(ConstantsString.ERROR_INPUT_ONLY_NUMBER);
            return false;
        }
        int pos = Integer.parseInt(position);
        int sectionLength = LineRepository.getLineByName(lineName).sections().size();
        if (pos > sectionLength + 1) {
            view.printMessage(ConstantsString.ERROR_CAN_NOT_ADD_POSITION_AT);
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
