package subway.view;

import subway.enums.LineInfo;
import subway.enums.LineMenu;

import java.util.Arrays;
import java.util.List;

public class LineView {

    public static void printLineMenu() {
        LineMenu[] lineMenu = LineMenu.values();
        List<LineMenu> menu = Arrays.asList(lineMenu);
        menu.stream().map(LineMenu::getTitle).limit(LineMenu.BACK.ordinal()).forEach(System.out::println);
        System.out.println();
    }

    public static void printAskLineNameToEnroll() {
        System.out.println(LineInfo.ASK_LINE_NAME_TO_ENROLL.getInfo());
    }

    public static void printAskUpLastStation() {
        System.out.println(LineInfo.ASK_UP_LAST_STATION.getInfo());
    }

    public static void printAskDownLastStation() {
        System.out.println(LineInfo.ASK_DOWN_LAST_STATION.getInfo());
    }

    public static void informLineEnrolled() {
        System.out.println(LineInfo.INFO_LINE_ENROLLED.getInfo());
    }


}
