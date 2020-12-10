package subway.view;

import static subway.view.MainMenu.WRONG_MENU_INPUT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import subway.controller.Management;
import subway.exception.SubwayCustomException;

public enum LineMenu {
    ADD_STATION("1", Management::addLine),
    DELETE_STATION("2",Management::deleteLine),
    SHOW_STATION_LIST("3",OutputView::showLineList),
    GO_BACK("B",null);

    private final String input;
    private final Runnable handler;

    LineMenu(String input, Runnable handler){
        this.input = input;
        this.handler = handler;
    }

    public static void execute(String input){
        try{
            Arrays.stream(values())
                .filter(value->value.input.equals(input))
                .findFirst()
                .orElseThrow(()->new SubwayCustomException(WRONG_MENU_INPUT_EXCEPTION_MESSAGE))
                .handler.run();
        } catch (NullPointerException exception){

        }
    }
}
