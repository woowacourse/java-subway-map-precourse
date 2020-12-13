package subway.domain.menu.submenu.action;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.constant.ActionMessage;

public class RegisterAction extends Action {
    public RegisterAction(char order, String category, String actionType, Scanner scanner) {
        super(order, category, actionType, scanner);
    }

    @Override
    public void runAction() {
        printRegisterMessage();
        String name = inputRegister();
        if (category.equals(CategoryType.STATION)) {
            registerStation(name);
        }
        printSuccessMessage();
    }

    private void printRegisterMessage() {
        System.out
                .println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER
                        + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER_NAME);
    }

    private String inputRegister() {
        String name = scanner.nextLine();
        System.out.println();
        return name;
    }

    private void registerStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    private void printSuccessMessage() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_REGISTER_SUBWAY
                + CommonMessage.SPACE + category + ActionMessage.SUCCESS_REGISTER_POSTPOSITION + CommonMessage.SPACE
                + ActionMessage.SUCCESS_REGISTER_END);
        System.out.println();
    }
}
