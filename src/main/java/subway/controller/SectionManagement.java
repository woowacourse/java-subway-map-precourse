package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menuType.ManagementMenuType;
import subway.view.menuView.SectionView;

import java.util.HashMap;

public class SectionManagement {
    private static SectionView sectionView = SectionView.getInstance();
    private static ManagementMenuType menu;
    private static HashMap<ManagementMenuType, matchedFunction> mapToFunction;

    static {
        SectionManagement.mapToFunction = new HashMap<>();
        mapToFunction.put(ManagementMenuType.CREATE, SectionManagement::registerSection);
        mapToFunction.put(ManagementMenuType.DELETE, SectionManagement::deleteSection);
        mapToFunction.put(ManagementMenuType.ESCAPE, () -> {});
    }

    public static void run() {
        do {
            try {
                sectionView.printMenu();
                menu = sectionView.getMenuSelection();
                mapToFunction.get(menu).run();
            } catch (RuntimeException e) {
                sectionView.printErrorMessage(e);
            }
        } while (!menu.equals(ManagementMenuType.ESCAPE));
    }

    private static void registerSection() {
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
