package subway.menu;

import java.util.Arrays;

import subway.controller.StationController;
import subway.controller.LineController;

public enum MainMenu {
    STATION_MANAGE("1", StationController::station),
    LINE_MANAGE("2", LineController::line),
    SECTION_MANAGE("3", StationController::station),
    PRINT_SUBWAY_MAP("4", StationController::station),
    QUIT("Q", StationController::station);

    private final String code;
    private final Runnable handler;
    
    MainMenu(String code, Runnable handler) {
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
