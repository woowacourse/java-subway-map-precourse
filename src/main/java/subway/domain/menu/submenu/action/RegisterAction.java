package subway.domain.menu.submenu.action;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
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
        String item = inputRegister();
        if (category.equals(CategoryType.STATION)) {
            registerStation(item);
        }
        printSuccessMessage();
    }

    private void printRegisterMessage() {
        System.out
                .println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER
                        + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER_NAME);
    }

    private String inputRegister() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    private void registerStation(String item) {
        LineRepository.addLine(new Line(item));
    }

    private void printSuccessMessage() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_REGISTER_SUBWAY
                + CommonMessage.SPACE + category + ActionMessage.SUCCESS_REGISTER_POSTPOSITION + CommonMessage.SPACE
                + ActionMessage.SUCCESS_REGISTER_END);
        System.out.println();
    }
}
