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
        if (category.equals(CategoryType.SECTION)) {
            registerSection();
            return;
        }

        printRegisterMessage();
        name = requestInputRegister();
        if (isErrorInput(name)) {
            return;
        }

        runDetailAction(name);
    }

    private boolean isErrorInput(String input) {
        return input.equals(CommonMessage.ERROR);
    }

    private void runDetailAction(String name) {
        String error = "";
        if (category.equals(CategoryType.STATION)) {
            registerStation(name);
        }

        if (category.equals(CategoryType.LINE)) {
            error = registerLine(name);
        }
        printSuccessMessage(error);
    }

    private void printRegisterMessage() {
        System.out
                .println(CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER
                        + CommonMessage.SPACE + category + CommonMessage.SPACE + ActionMessage.INPUT_REGISTER_NAME);
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
        return inputView.inputRegister(category);
    }

    private String requestInputTerminalStation() {
        return inputView.inputTerminalStation();
    }

    private String requestInputTerminalStation(String upwardStation) {
        return inputView.inputTerminalStation(upwardStation);
    }

    private String requestInputSectionLine() {
        return inputView.inputSectionLine();
    }

    private String requestInputSectionStation(Line line) {
        String name = inputView.inputTerminalStation();

        if (!isErrorInput(name)) {
            return inputView.inputSectionStation(name, line);
        }
        return name;
    }

    private String requestInputSectionOrder(Line line) {
        return inputView.inputSectionOrder(line);
    }

    private void registerStation(String name) {
        StationRepository.addStation(new Station(name));
    }

    private String registerLine(String name) {
        Line line = new Line(name);
        String upwardStation = registerInputLine();
        if (isErrorInput(upwardStation)) {
            return upwardStation;
        }

        String downStation = registerInputLine(upwardStation);
        if (isErrorInput(downStation)) {
            return downStation;
        }

        line.addStation(new Station(upwardStation));
        line.addStation(new Station(downStation));
        LineRepository.addLine(line);
        return name;
    }

    private String registerInputLine() {
        printRegisterMessage(ActionMessage.INPUT_UPWARD_TERMINAL_STATION);
        return requestInputTerminalStation();
    }

    private String registerInputLine(String upwardStation) {
        printRegisterMessage(ActionMessage.INPUT_DOWN_TERMIANL_STATION);
        return requestInputTerminalStation(upwardStation);
    }

    private void registerSection() {
        String line = registerInputSectionLine();
        if (isErrorInput(line)) {
            return;
        }

        String name = registerInputSectionStation(line);
        if (isErrorInput(name)) {
            return;
        }

        String order = registerInputSectionOrder(line);
        if (isErrorInput(String.valueOf(order))) {
            return;
        }
        realRegisterSection(line, name, Integer.parseInt(order));
    }

    private void realRegisterSection(String line, String name, int order) {
        LineRepository.lines().stream().filter(item -> item.getName().equals(line)).findFirst().get().getStationList()
                .add(order, new Station(name));

        printSuccessMessage(line);
    }

    private String registerInputSectionLine() {
        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_LINE);
        return requestInputSectionLine();
    }

    private String registerInputSectionStation(String line) {
        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_STATION);
        return requestInputSectionStation(
                LineRepository.lines().stream().filter(i -> i.getName().equals(line)).findFirst().get());
    }

    private String registerInputSectionOrder(String line) {
        printRegisterSectionMessage(ActionMessage.INPUT_SECTION_ORDER);
        return requestInputSectionOrder(
                LineRepository.lines().stream().filter(i -> i.getName().equals(line)).findFirst().get());
    }

    private void printSuccessMessage(String error) {
        if (isErrorInput(error)) {
            return;
        }
        System.out.println(CommonMessage.INFO + CommonMessage.SPACE + ActionMessage.SUCCESS_SUBWAY + CommonMessage.SPACE
                + category + ActionMessage.SUCCESS_POSTPOSITION + CommonMessage.SPACE + ActionMessage.SUCCESS_REGISTER);
        System.out.println();
    }
}
