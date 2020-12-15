package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;

public class SectionManagementController {

    private static SectionManagementController instance;

    private SectionManagementController() {
    }

    public static SectionManagementController getInstance() {
        if (instance == null) {
            instance = new SectionManagementController();
        }
        return instance;
    }

    public void addStationInSections(String lineName, String stationName, String position) {
        Line line = LineRepository.getLineByName(lineName);
        Sections sections = line.getSections();
        int positionNum = Integer.parseInt(position);
        sections.addSection(stationName, positionNum);
    }

    public void deleteStationInSection(String lineName, String stationName) {
        Line line = LineRepository.getLineByName(lineName);
        Sections sections = line.getSections();
        sections.deleteSection(stationName);
    }
}
