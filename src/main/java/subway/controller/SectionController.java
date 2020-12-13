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
            line.addStation(sectionView.getOrder(), getStationToAddSection());
            sectionView.announceAddSectionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            addSection();
        }
    }

    private Line getLineToAddSection() {
        Name name = sectionView.getLineNameToAddSection();
        return LineRepository.getByName(name);
    }

    private Station getStationToAddSection() {
        Name name = sectionView.getStationNameOfSection();
        return StationRepository.getByName(name);
    }

    public void deleteSection() {
        Line line = getLineOfSectionToDelete();
        line.deleteSection(getStationOfSectionToDelete());
        sectionView.announceDeleteSectionSuccess();
    }

    private Line getLineOfSectionToDelete() {
        Name name = sectionView.getLineNameToDeleteSection();
        return LineRepository.getByName(name);
    }

    private Station getStationOfSectionToDelete() {
        Name name = sectionView.getStationNameOfSection();
        return StationRepository.getByName(name);
    }
}
