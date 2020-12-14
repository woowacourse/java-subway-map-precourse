package subway.domain.menu.submenu.action;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.action.constant.ActionMessage;
import subway.view.InputView;

public class RegisterAction extends Action {
    public RegisterAction(char order, String category, String actionType, InputView inputView) {
        super(order, category, actionType, inputView);
    }

    @Override
    public void runAction() {
        String name;

        // 미구현 - 구간 추가할 때 고칠 예정.
        if (category.equals(CategoryType.SECTION)) {
            registerSection();
        }

        printRegisterMessage();
        name = requestInputRegister();
        if (name.equals(CommonMessage.ERROR)) {
            return;
        }

        runDetailAction(name);
    }

    private void runDetailAction(String name) {
        if (category.equals(CategoryType.STATION)) {
            registerStation(name);
        }

        if (category.equals(CategoryType.LINE)) {
            registerLine(name);
        }

        if (category.equals(CategoryType.SECTION)) {
            registerSection();
        }
        printSuccessMessage();
    }

    private String printRegisterMessage() {
        String message = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER
                        + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER_NAME;
        return message;
    }

    private void printRegisterMessage(String pos) {
        System.out.print(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER
                + CommonMessage.SPACE + category + ActionMessage.INPUT_POSTPOSITION + CommonMessage.SPACE);

        if (pos.equals(ActionMessage.INPUT_UPWARD_TERMINAL_STATION)) {
            System.out.println(ActionMessage.INPUT_UPWARD_TERMINAL_STATION);
            return;
        }

        System.out.println(ActionMessage.INPUT_DOWN_TERMIANL_STATION);
    }

    private void printRegisterSectionMessage(String type) {
        System.out.print(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE);
        if (type.equals(ActionMessage.INPUT_SECTION_LINE)) {
            System.out.print(ActionMessage.INPUT_SECTION_LINE + CommonMessage.SPACE);
        }

        if (type.equals(ActionMessage.INPUT_SECTION_STATION)) {
            System.out.print(ActionMessage.INPUT_SECTION_STATION + CommonMessage.SPACE);
        }

        if (type.equals(ActionMessage.INPUT_SECTION_ORDER)) {
            System.out.print(ActionMessage.INPUT_SECTION_ORDER + CommonMessage.SPACE);
        }

        System.out.println(ActionMessage.INPUT_SECTION_MESSAGE);
    }

    private String requestInputRegister() {
        return inputView.inputRegister();
    }

    private void registerStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    // 임시 - 컴파일 에러 방지.
    private String inputRegister() {
        String name = inputView.getScanner().nextLine();
        System.out.println();
        return name;
    }

    private void registerLine(String name) {
        Line line = new Line(name);

        printRegisterMessage(ActionMessage.INPUT_UPWARD_TERMINAL_STATION);
        String upward = inputRegister();

        printRegisterMessage(ActionMessage.INPUT_DOWN_TERMIANL_STATION);
        String down = inputRegister();

        line.addStation(new Station(upward));
        line.addStation(new Station(down));

        LineRepository.addLine(line);
    }

    private void registerSection() {
        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_LINE);
        String line = inputRegister();

        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_STATION);
        String name = inputRegister();

        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_ORDER);
        int order = Integer.parseInt(inputRegister()) - 1;

        LineRepository.lines().stream().filter(item -> item.getName().equals(line)).findFirst().get().getStationList()
                .add(order, new Station(name));

        printSuccessMessage();
    }

    private void printSuccessMessage() {
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_SUBWAY + CommonMessage.SPACE
                + category + ActionMessage.SUCCESS_POSTPOSITION + CommonMessage.SPACE + ActionMessage.SUCCESS_REGISTER);
        System.out.println();
    }
}
