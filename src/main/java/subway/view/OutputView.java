package subway.view;

import subway.message.GuideMessage;

public class OutputView {

    private static void spacePrint() {
        System.out.println();
    }

    public static void mainMenuPrint() {
        System.out.println(GuideMessage.MAIN_FUNCTION_LIST.getGuideMessage());
        spacePrint();
    }

    public static void OptionChoicePrint() {
        System.out.println(GuideMessage.CHOICE_OPTION_LIST.getGuideMessage());
    }
}
