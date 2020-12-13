package subway.domain.menu.submenu.action;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.constant.ActionMessage;

public class ViewAction extends Action {
    public ViewAction(char order, String category, String actionType, Scanner scanner) {
        super(order, category, actionType, scanner);
    }

    @Override
    public void runAction() {
        printViewMessage();
        if (category.equals(CategoryType.STATION)) {
            viewStation();
        }

        if (category.equals(CategoryType.LINE)) {
            viewLine();
        }
    }

    private void printViewMessage() {
        System.out.println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + category
                + CommonMessage.SPACE + ActionMessage.VIEW_MESSAGE);
    }

    private void viewStation() {
        StationRepository.stations().stream().forEach(station -> System.out.println(CommonMessage.INFO + CommonMessage.SPACE + station.getName()));
        System.out.println();
    }

    private void viewLine() {
        LineRepository.lines().stream().forEach(line -> System.out.println(CommonMessage.INFO + CommonMessage.SPACE + line.getName()));
        System.out.println();
    }
}
