package subway.view;

import java.util.Arrays;
import java.util.List;

public class MainScreen implements Screen {
    private static final String TITLE = "메인 화면";
    public static final int MAX_MENU_NUMBER = 4;
    public static final String SPECIAL_COMMAND = "Q";
    public static final int SPECIAL_COMMAND_TO_INT = -1;

    private static final List<Element> MAIN_MENU_ELEMENT = Arrays.asList(
            Element.STATION, Element.LINE, Element.PATH, Element.MAP
    );

    private static final List<Action> MAIN_MENU_ACTION = Arrays.asList(
            Action.MANAGE, Action.MANAGE, Action.MANAGE, Action.PRINT, Action.EXIT
    );

    @Override
    public void show() {
        OutputView.printTitle(DOUBLE_SHARP + TITLE);
        int i;
        for (i = 0; i < MAIN_MENU_ELEMENT.size(); i++) {
            OutputView.printMenus(Integer.toString(i + 1) + DOT + MAIN_MENU_ELEMENT.get(i).toString() + SPACE + MAIN_MENU_ACTION.get(i).toString());
        }
        OutputView.printMenus(EXIT_MARK + MAIN_MENU_ACTION.get(i).toString());
    }

    @Override
    public void getCommand() {
        OutputView.print(CHANGE_LINE + DOUBLE_SHARP + SELECT_FUNCTION);
    }

//    @Override
//    public void mapping(int command) {
//        final Element element = MAIN_MENU_ELEMENT.get(command);
//        if(element == Element.STATION){
//            // 역 관리 매핑
//        }
//
//        if(element == Element.LINE){
//            // 노선 관리 매핑
//        }
//
//        if(element == Element.PATH){
//            // 구간 관리 매핑
//        }
//
//        if(element == Element.MAP){
//            // 지하철 노선도 출력 매핑
//        }
//    }

    @Override
    public int getMaxMenuNumber() {
        return MAX_MENU_NUMBER;
    }

    @Override
    public String getSpecialCommand() {
        return SPECIAL_COMMAND;
    }

    @Override
    public int parseSpecialCommandtoInt() {
        return SPECIAL_COMMAND_TO_INT;
    }
}
