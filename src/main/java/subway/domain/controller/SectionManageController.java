package subway.domain.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.input.SectionManageInput;

import java.util.Scanner;

public class SectionManageController {

    SectionManageInput input = new SectionManageInput();

    public void processEnrollSection(Line line, Station station, int order) {
        line.addOrderedStation(station, order);
    }


}
