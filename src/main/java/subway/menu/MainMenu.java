package subway.menu;

import java.util.Arrays;

import subway.controller.StationController;
import subway.controller.SubwayController;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.view.Output;

public enum MainMenu {
    STATION_MANAGE("1", StationController::station),
    LINE_MANAGE("2", LineController::line),
    SECTION_MANAGE("3", SectionController::section),
    PRINT_SUBWAY_MAP("4", Output::printSubwayMap),
    QUIT("Q", SubwayController::quit);

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
