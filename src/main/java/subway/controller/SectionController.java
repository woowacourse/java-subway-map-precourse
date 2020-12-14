package subway.controller;

import subway.domain.*;
import subway.view.OutputView;
import subway.view.SectionView;

import java.util.Scanner;

public class SectionController {
    private static SectionController sectionController = null;
    private final SectionView sectionView;

    private SectionController(Scanner scanner) {
        sectionView = SectionView.getInstance(scanner);
    }

    public static SectionController getInstance(Scanner scanner) {
        if (sectionController == null) {
            sectionController = new SectionController(scanner);
            return sectionController;
        }
        return sectionController;
    }

    public void addSection() {
        try {
            Line line = getLineToAddSection();
            Station station = getStationToAddSection();
            line.addStation(sectionView.getOrder(), station);
            sectionView.announceAddSectionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            addSection();
        }
    }

    private Line getLineToAddSection() {
        return getLine(sectionView.getLineNameToAddSection());
    }

    private Station getStationToAddSection() {
        return getStation(sectionView.getStationNameOfSection());
    }

    public void deleteSection() {
        try {
            Line line = getLineOfSectionToDelete();
            line.deleteSection(getStationOfSectionToDelete());
            sectionView.announceDeleteSectionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            deleteSection();
        }
    }

    private Line getLineOfSectionToDelete() {
        return getLine(sectionView.getLineNameToDeleteSection());
    }

    private Station getStationOfSectionToDelete() {
        return getStation(sectionView.getStationNameOfSection());
    }

    private Station getStation(Name name) {
        return StationRepository.getByName(name);
    }

    private Line getLine(Name name) {
        return LineRepository.getByName(name);
    }
}
