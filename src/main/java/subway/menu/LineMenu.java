package subway.menu;

import java.util.Arrays;

import subway.controller.LineController;

public enum LineMenu {
    ADD_LINE("1",LineController::addLine),
    DELETE_LINE("2",LineController::deleteLine),
    PRINT_LINE("3",LineController::printLine),
    BACK("B",LineController::printLine);
	
    private final String code;
    private final Runnable handler;
	
    LineMenu(String code, Runnable handler){
        this.code = code;
        this.handler = handler;
    }
	
    public String getCode() {
        return code;
    }
	
    public Runnable getHandler() {
        return handler;
    }
	
    public static void execute(String input) {
        Arrays.stream(values())
        .filter(value -> value.getCode().equals(input))
        .findFirst()
        .orElseThrow(()->new IllegalArgumentException())
        .getHandler().run();
    }
}
