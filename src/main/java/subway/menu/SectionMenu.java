package subway.menu;

import java.util.Arrays;

import subway.controller.SectionController;
import subway.controller.SubwayController;

public enum SectionMenu {
    ADD_SECTION("1", SectionController::addSection),
    DELETE_SECTION("2", SectionController::deleteSection),
    BACK("B", SubwayController::run);
	
    private final String code;
    private final Runnable handler;
	
    SectionMenu(String code, Runnable handler){
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
