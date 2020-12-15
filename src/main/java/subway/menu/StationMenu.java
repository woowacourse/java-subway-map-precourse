package subway.menu;

import java.util.Arrays;

import subway.controller.StationController;
import subway.controller.SubwayController;
import subway.view.Output;

public enum StationMenu {
    ADD_STATION("1",StationController::addStation),
    DELETE_STATION("2",StationController::deleteStation),
    PRINT_STATION("3",Output::printStation),
    BACK("B",SubwayController::run);
	
    private final String code;
    private final Runnable handler;
	
    StationMenu(String code, Runnable handler){
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
