package subway.domain;

import subway.domain.menu.mainmenu.*;
import subway.domain.menu.stationmenu.*;

import java.util.*;

public class MenuRepository {
    public static final List<String> mainMenuButtons = new ArrayList<>(Arrays.asList
            (StationMenu.MENU_BUTTON, LineMenu.MENU_BUTTON, IntervalMenu.MENU_BUTTON, PrintIntervalsMenu.MENU_BUTTON, ExitMenu.MENU_BUTTON));
    public static final List<String> stationMenuButtons = new ArrayList<>(Arrays.asList
            (RegisterStationMenu.MENU_BUTTON, DeleteStationMenu.MENU_BUTTON, PrintStationsMenu.MENU_BUTTON, ExitToStationMenu.MENU_BUTTON));
    public static final List<String> lineMenuButtons =
            new ArrayList<>(Arrays.asList("1", "2", "3", "B"));
    public static final List<String> intervalMenuButtons =
            new ArrayList<>(Arrays.asList("1", "2", "B"));

    public static final Map<String, Menu> mainMenu = new HashMap<>();
    public static final Map<String, StationManageMenu> stationMenu = new HashMap<>();

    static {
        mainMenu.put(StationMenu.MENU_BUTTON, new StationMenu());
        mainMenu.put(LineMenu.MENU_BUTTON, new LineMenu());
        mainMenu.put(IntervalMenu.MENU_BUTTON, new IntervalMenu());
        mainMenu.put(PrintIntervalsMenu.MENU_BUTTON, new PrintIntervalsMenu());

        stationMenu.put(RegisterStationMenu.MENU_BUTTON, new RegisterStationMenu());
        stationMenu.put(DeleteStationMenu.MENU_BUTTON, new DeleteStationMenu());
        stationMenu.put(PrintStationsMenu.MENU_BUTTON, new PrintStationsMenu());
    }
}
