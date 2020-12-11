package subway.view;

import subway.domain.LineRepository;
import subway.enums.ErrorMessage;
import subway.enums.LineInfo;
import subway.enums.LineMenu;

import java.util.Arrays;
import java.util.List;

public class LineView {

    public static void printLineMenu() {
        LineMenu[] lineMenu = LineMenu.values();
        List<LineMenu> menu = Arrays.asList(lineMenu);
        menu.stream().map(LineMenu::getTitle).forEach(System.out::println);
        System.out.println();
    }

    public static void printAskLineNameToRegister() {
        System.out.println(LineInfo.ASK_LINE_NAME_TO_REGISTER.getInfo());
    }

    public static void printAskUpLastStation() {
        System.out.println(LineInfo.ASK_UP_LAST_STATION.getInfo());
    }

    public static void printAskDownLastStation() {
        System.out.println(LineInfo.ASK_DOWN_LAST_STATION.getInfo());
    }

    public static void informLineRegistered() {
        System.out.println(LineInfo.INFO_LINE_REGISTERED.getInfo());
    }

    public static void informLineDuplicated() {
        System.err.println(ErrorMessage.LINE_DUPLICATION.getMessage());
    }

    public static void informNameLengthUnder2() {
        System.err.println(ErrorMessage.LINE_NAME_LENGTH_UNDER_2.getMessage());
    }

    public static void informLastUpDownStationDuplication() {
        System.err.println(ErrorMessage.LAST_UP_AND_DOWN_STATION_DUPLICATION.getMessage());
    }

    public static void printAskLineNameToDelete() {
        System.out.println(LineInfo.ASK_LINE_NAME_TO_DELETE.getInfo());
    }

    public static void informLineDeleted() {
        System.out.println(LineInfo.INFO_LINE_DELETED.getInfo());
    }

    public static void informLineNotExist() {
        System.err.println(ErrorMessage.LINE_NOT_EXIST.getMessage());
    }

    public static String printLineList() {
        System.out.println(LineInfo.LINE_LIST.getInfo());
        LineRepository.lines().stream()
                .map(line -> LineInfo.INFO.getInfo() + line.getName())
                .forEach(System.out::println);
        return LineMenu.LIST.getCommand();
    }

    public static void informNoMenu() {
        MainView.informUnableCommand();
    }
}
