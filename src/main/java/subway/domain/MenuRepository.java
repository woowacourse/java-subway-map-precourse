package subway.domain;

import subway.domain.menu.intervalmenu.DeleteIntervalMenu;
import subway.domain.menu.intervalmenu.ExitFromIntervalMenu;
import subway.domain.menu.intervalmenu.IntervalManageMenu;
import subway.domain.menu.intervalmenu.RegisterIntervalMenu;
import subway.domain.menu.linemenu.*;
import subway.domain.menu.mainmenu.*;
import subway.domain.menu.stationmenu.*;

import java.util.*;

public class MenuRepository {
    public static final List<String> mainMenuButtons = new ArrayList<>(Arrays.asList
            (StationMenu.MENU_BUTTON, LineMenu.MENU_BUTTON, IntervalMenu.MENU_BUTTON, PrintIntervalsMenu.MENU_BUTTON, ExitMenu.MENU_BUTTON));
    public static final List<String> stationMenuButtons = new ArrayList<>(Arrays.asList
            (RegisterStationMenu.MENU_BUTTON, DeleteStationMenu.MENU_BUTTON, PrintStationsMenu.MENU_BUTTON, ExitFromStationMenu.MENU_BUTTON));
    public static final List<String> lineMenuButtons = new ArrayList<>(Arrays.asList
            (RegisterLineMenu.MENU_BUTTON, DeleteLineMenu.MENU_BUTTON, PrintLinesMenu.MENU_BUTTON, ExitFromLineMenu.MENU_BUTTON));
    public static final List<String> intervalMenuButtons = new ArrayList<>(Arrays.asList
            (RegisterIntervalMenu.MENU_BUTTON, DeleteIntervalMenu.MENU_BUTTON, ExitFromIntervalMenu.MENU_BUTTON));

    public static final Map<String, Menu> mainMenu = new HashMap<>();
    public static final Map<String, StationManageMenu> stationMenu = new HashMap<>();
    public static final Map<String, LineManageMenu> lineMenu = new HashMap<>();
    public static final Map<String, IntervalManageMenu> intervalMenu = new HashMap<>();

    static {
        mainMenu.put(StationMenu.MENU_BUTTON, new StationMenu());
        mainMenu.put(LineMenu.MENU_BUTTON, new LineMenu());
        mainMenu.put(IntervalMenu.MENU_BUTTON, new IntervalMenu());
        mainMenu.put(PrintIntervalsMenu.MENU_BUTTON, new PrintIntervalsMenu());

        stationMenu.put(RegisterStationMenu.MENU_BUTTON, new RegisterStationMenu());
        stationMenu.put(DeleteStationMenu.MENU_BUTTON, new DeleteStationMenu());
        stationMenu.put(PrintStationsMenu.MENU_BUTTON, new PrintStationsMenu());

        lineMenu.put(RegisterLineMenu.MENU_BUTTON, new RegisterLineMenu());
        lineMenu.put(DeleteLineMenu.MENU_BUTTON, new DeleteLineMenu());
        lineMenu.put(PrintLinesMenu.MENU_BUTTON, new PrintLinesMenu());

        intervalMenu.put(RegisterIntervalMenu.MENU_BUTTON, new RegisterIntervalMenu());
        intervalMenu.put(DeleteIntervalMenu.MENU_BUTTON, new DeleteIntervalMenu());
    }
}
