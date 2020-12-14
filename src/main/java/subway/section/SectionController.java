package subway.section;

import subway.common.CommonService;
import subway.line.LineService;
import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.station.view.StationInputView;
import subway.view.InputView;
import subway.view.section.SectionManagementView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SectionController {
    private static final char ADD_SECTION = '1';
    private static final char DELETE_SECTION = '2';
    private static final char GO_BACK = 'B';

    public static void sectionManagement(InputView inputView) {
        List<Character> optionList = Arrays.asList(ADD_SECTION, DELETE_SECTION, GO_BACK);

        while (true) {
            SectionManagementView.showSectionManagementMenu();
            char option = CommonService.selectOption(optionList, inputView);

            if (option == GO_BACK) {
                break;
            }

            if (selectOption(option, inputView)) {
                break;
            }
        }
    }

    private static boolean selectOption(char option, InputView inputView) {
        if (option == ADD_SECTION) {
            return addNewSection(inputView);
        }
        if (option == DELETE_SECTION) {
            return deleteSection(inputView);
        }
        return false;
    }

    private static boolean addNewSection(InputView inputView) {
        SectionManagementView.askAddSectionLineName();
        String lineName = inputView.lineName();
        boolean success = SectionService.addSection(lineName, inputView);
        if (success) {
            SectionManagementView.addSectionComplete();
        }
        return success;
    }

    private static boolean deleteSection(InputView inputView) {
        SectionManagementView.askDeleteSectionLineName();
        String lineName = inputView.lineName();
        boolean success = SectionService.deleteSection(lineName, inputView);
        if (success) {
            SectionManagementView.deleteSectionComplete();
        }
        return success;
    }
}
