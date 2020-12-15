package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.service.LineService;
import subway.domain.service.SectionService;
import subway.domain.service.StationService;
import subway.view.DetailView;
import utils.Category;
import utils.ScriptUtils;

public class SectionController {
    private static DetailView sectionView = new DetailView(Category.SECTION);
    private static int askCount = 2;
    private static int ADD = 1;

    private SectionController() { }

    public static void manageSection(Scanner scanner, int selection) {
        if (selection == ADD) {
            addSection(scanner, selection);
            return;
        }

        deleteSection(scanner, selection);
    }

    private static void deleteSection(Scanner scanner, int selection) {
        Line line = askLine(scanner, selection);
        Station station = askStation(scanner, selection);
        if (line != null && station != null) {
            SectionService.deleteSection(line, station);
        }
    }

    private static void addSection(Scanner scanner, int selection) {
        Line line = askLine(scanner, selection);
        Station station = askStation(scanner, selection);
        int idx = askIdx(scanner, selection, line);

        if (line != null && station != null && idx >= 0) {
            SectionService.createSection(line, station, idx);
        }
    }

    private static int askIdx(Scanner scanner, int selection, Line line) {
        int idx = sectionView.askSectionNumber(scanner, ScriptUtils.ASK_ANSWER_FOR_SECTION[selection-1][2]);
        if (idx < 0) {
            return idx;
        }
        try {
            if (idx > line.getLength()) {
                throw new IllegalArgumentException(ScriptUtils.ERROR_OUT_OF_BOUNDARY);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return idx;
    }

    private static Station askStation(Scanner scanner, int selection) {
        try {
            String stationName = sectionView.askSection(scanner, ScriptUtils.ASK_ANSWER_FOR_SECTION[selection-1][1]);
            SectionService.checkDuplicate(1, stationName);
            return StationService.readStation(stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Line askLine(Scanner scanner, int selection) {
        try {
            String lineName = sectionView.askSection(scanner, ScriptUtils.ASK_ANSWER_FOR_SECTION[selection-1][0]);
            SectionService.checkDuplicate(0, lineName);
            return LineService.readLine(lineName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
