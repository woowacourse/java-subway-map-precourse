package subway.screen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ScreenStack {
    private static final Deque<Screen> screenStack = new ArrayDeque<>();
    
    public static void addScreenByScreenType(ScreenType screenType) {
        screenStack.add(ScreenRepository.getScreenByType(screenType));
    }
    
    public static void addManagerScreenByEntityType(EntityType entityType) {
        if(entityType == EntityType.STATION) {
            addScreenByScreenType(ScreenType.STATION_MANAGEMENT);
        }
        if(entityType == EntityType.LINE) {
            addScreenByScreenType(ScreenType.LINE_MANAGEMENT);
        }
        if(entityType == EntityType.ROUTE) {
            addScreenByScreenType(ScreenType.ROUTE_MANAGEMENT);
        }
    }
    
    public static Screen peekScreen() {
        return screenStack.peekLast();
    }
    
    public static void popScreen() {
        screenStack.pollLast();
    }
    
    public static boolean isEmpty() {
        return screenStack.isEmpty();
    }
}
