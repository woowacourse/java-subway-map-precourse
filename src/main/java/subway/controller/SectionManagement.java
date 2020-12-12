package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menuType.FunctionType;
import subway.view.OutputView;
import subway.view.menuView.SectionView;

public class SectionManagement {
    private static SectionView sectionView = SectionView.getInstance();
    private static FunctionType menu;

    public static void run() {
        do {
            try {
                sectionView.showMenu();
                menu = sectionView.getFunctionSelection();
                runSelectedMenuFunction();
            } catch (Exception e) {
                OutputView.showErrorMessage(e);
            }
        } while (!menu.equals(FunctionType.ESCAPE));
    }

    private static void runSelectedMenuFunction() {
        if (menu.equals(FunctionType.CREATE)) {
            createSection();
        }
        if (menu.equals(FunctionType.DELETE)) {
            deleteSection();
        }
    }

    private static void createSection() {
        Station station = StationRepository.searchByName(sectionView.getStationNameToCreate());
        Line line = LineRepository.searchByName(sectionView.getLineNameToCreate());
        int index = sectionView.getIndex();

        line.addStation(index, station);
        sectionView.printCreateDone();
    }

    private static void deleteSection() {
        Station station = StationRepository.searchByName(sectionView.getStationNameToDelete());
        Line line = LineRepository.searchByName(sectionView.getLineNameToDelete());

        line.deleteStation(station);
        sectionView.printDeleteDone();
    }

}
