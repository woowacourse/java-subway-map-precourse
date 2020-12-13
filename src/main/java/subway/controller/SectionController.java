package subway.controller;

import subway.domain.*;
import subway.domain.validator.SectionValidator;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SectionView;
import subway.view.StationView;

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
        Line line = getExistingLine();
        Station station = getStationToAddSection(line);
        line.addStation(getOrder(line), station);

        sectionView.announceAddSectionSuccess();
    }

    private Line getExistingLine() {
        try {
            Name lineName = sectionView.getLineNameToAddSection();
            return LineRepository.getByName(lineName);
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getExistingLine();
        }
    }

    private Station getStationToAddSection(Line line) {
        try {
            Name stationName = sectionView.getStationNameOfSection();
            Station station = StationRepository.getByName(stationName);
            SectionValidator.checkStationNotOnLine(station, line);
            return station;
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getStationToAddSection(line);
        }
    }

    private Order getOrder(Line line) {
        try {
            Order order = sectionView.getOrder();
            SectionValidator.checkValidOrderInLine(order, line);
            return order;
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getOrder(line);
        }
    }

    public void deleteSection() {
        Line line = getLineOfSectionToDelete();
        Station station = getStationOfSectionToDelete();
        line.deleteSection(station);
        sectionView.announceDeleteSectionSuccess();
    }

    private Line getLineOfSectionToDelete() {
        Name lineName = sectionView.getLineNameOfSection();
        return LineRepository.getByName(lineName);
    }

    private Station getStationOfSectionToDelete() {
        Name stationName = sectionView.getStationNameOfSection();
        return StationRepository.getByName(stationName);
    }
}
