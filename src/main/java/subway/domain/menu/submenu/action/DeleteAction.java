package subway.domain.menu.submenu.action;

import java.util.Scanner;

import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.constant.ActionMessage;

public class DeleteAction extends Action {
    public DeleteAction(char order, String category, String actionType, Scanner scanner) {
        super(order, category, actionType, scanner);
    }

    @Override
    public void runAction() {
        printDeleteMessage();
        String name = inputDelete();
        if (category.equals(CategoryType.STATION)) {
            deleteStation(name);
        }

        if (category.equals(CategoryType.LINE)) {
            deleteLine(name);
        }
        printSuccessMessage();
    }

    private void printDeleteMessage() {
        System.out.println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_DELETE
                + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_DELETE_NAME);
    }

    private String inputDelete() {
        String name = scanner.nextLine();
        System.out.println();
        return name;
    }

    private void deleteStation(String name) {
        StationRepository.deleteStation(name);
    }

    private void deleteLine(String name) {
        LineRepository.deleteLineByName(name);
    }

    private void printSuccessMessage() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_SUBWAY + CommonMessage.SPACE
                + category + ActionMessage.SUCCESS_POSTPOSITION + CommonMessage.SPACE + ActionMessage.SUCCESS_DELETE);
        System.out.println();
    }
}
