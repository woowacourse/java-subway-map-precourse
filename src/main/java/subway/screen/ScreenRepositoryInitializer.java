package subway.screen;

public class ScreenRepositoryInitializer {
    public static void initialize() {
        ScreenRepository.clear();
        
        addMainScreen();
        addStationManagementScreen();
        addLineManagementScreen();
        addRouteManagementScreen();
    }
    
    private static void addMainScreen() {
        Screen mainScreen = new Screen(ScreenType.MAIN);
        
        mainScreen.addChoice(new Choice(CommandType.ONE, EntityType.STATION, ActionType.MANAGE));
        mainScreen.addChoice(new Choice(CommandType.TWO, EntityType.LINE, ActionType.MANAGE));
        mainScreen.addChoice(new Choice(CommandType.THREE, EntityType.ROUTE, ActionType.MANAGE));
        mainScreen.addChoice(new Choice(CommandType.FOUR, EntityType.MAP, ActionType.PRINT));
        mainScreen.addChoice(new Choice(CommandType.QUIT, EntityType.NONE, ActionType.EXIT));
        
        ScreenRepository.addScreen(mainScreen);
    }
    
    private static void addStationManagementScreen() {
        Screen stationManagementScreen = new Screen(ScreenType.STATION_MANAGEMENT);
        
        stationManagementScreen.addChoice(new Choice(CommandType.ONE, EntityType.STATION, ActionType.REGISTER));
        stationManagementScreen.addChoice(new Choice(CommandType.TWO, EntityType.STATION, ActionType.DELETE));
        stationManagementScreen.addChoice(new Choice(CommandType.THREE, EntityType.STATION, ActionType.SHOW));
        stationManagementScreen.addChoice(new Choice(CommandType.BACK, EntityType.NONE, ActionType.MOVE_BACK));
        
        ScreenRepository.addScreen(stationManagementScreen);
    }
    
    private static void addLineManagementScreen() {
        Screen lineManagementScreen = new Screen(ScreenType.LINE_MANAGEMENT);
        
        lineManagementScreen.addChoice(new Choice(CommandType.ONE, EntityType.LINE, ActionType.REGISTER));
        lineManagementScreen.addChoice(new Choice(CommandType.TWO, EntityType.LINE, ActionType.DELETE));
        lineManagementScreen.addChoice(new Choice(CommandType.THREE, EntityType.LINE, ActionType.SHOW));
        lineManagementScreen.addChoice(new Choice(CommandType.BACK, EntityType.NONE, ActionType.MOVE_BACK));
        
        ScreenRepository.addScreen(lineManagementScreen);
    }
    
    private static void addRouteManagementScreen() {
        Screen routeManagementScreen = new Screen(ScreenType.ROUTE_MANAGEMENT);
        
        routeManagementScreen.addChoice(new Choice(CommandType.ONE, EntityType.ROUTE, ActionType.REGISTER));
        routeManagementScreen.addChoice(new Choice(CommandType.TWO, EntityType.ROUTE, ActionType.DELETE));
        routeManagementScreen.addChoice(new Choice(CommandType.BACK, EntityType.NONE, ActionType.MOVE_BACK));
        
        ScreenRepository.addScreen(routeManagementScreen);
    }
}
