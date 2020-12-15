package subway.section;

import subway.line.Line;
import subway.line.LineService;
import subway.line.validation.CheckAlreadyRegisteredStation;
import subway.line.validation.CheckNotExistStation;
import subway.line.validation.CheckRightSectionNumber;
import subway.main.SubwayController;
import subway.station.Station;
import subway.station.StationService;
import subway.view.InputView;
import subway.view.section.SectionManagementView;

import java.util.Arrays;
import java.util.List;

public class SectionController {
    private static final char ADD_SECTION = '1';
    private static final char DELETE_SECTION = '2';
    private static final char GO_BACK = 'B';

    public static void sectionManagement(InputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_SECTION, DELETE_SECTION, GO_BACK);

        while (true) {
            SectionManagementView.showSectionManagementMenu();
            char option = SubwayController.selectOption(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, InputView inputView) {
        try {
            if (option == ADD_SECTION) {
                return addNewSection(inputView);
            }
            if (option == DELETE_SECTION) {
                return deleteSection(inputView);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean addNewSection(InputView inputView) {
        Line line = getAddSectionLine(inputView);
        Station station = getAddSectionStation(line, inputView);
        int sectionOrder = getAddSectionOrder(line, inputView);
        boolean success = SectionService.addSection(line, station, sectionOrder);

        if (success) {
            SectionManagementView.addSectionComplete();
        }

        return success;
    }

    private static Line getAddSectionLine(InputView inputView) {
        SectionManagementView.askAddSectionLineName();
        String lineName = inputView.lineName();
        return LineService.findLine(lineName);
    }

    private static Station getAddSectionStation(Line line, InputView inputView) {
        SectionManagementView.askAddStationName();
        String stationName = inputView.stationName();
        CheckAlreadyRegisteredStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }

    private static int getAddSectionOrder(Line line, InputView inputView) {
        SectionManagementView.askStationOrder();
        String number = inputView.sectionNumber();
        CheckRightSectionNumber.validation(line, number);
        return Integer.parseInt(number);
    }

    private static boolean deleteSection(InputView inputView) {
        Line line = getDeleteSectionLine(inputView);
        Station station = getDeleteSectionStation(line, inputView);
        boolean success = SectionService.deleteSection(line, station);

        if (success) {
            SectionManagementView.deleteSectionComplete();
        }

        return success;
    }

    private static Line getDeleteSectionLine(InputView inputView) {
        SectionManagementView.askDeleteSectionLineName();
        String lineName = inputView.lineName();
        return LineService.findLine(lineName);
    }

    private static Station getDeleteSectionStation(Line line, InputView inputView) {
        SectionManagementView.askDeleteSectionStation();
        String stationName = inputView.stationName();
        CheckNotExistStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }
}
