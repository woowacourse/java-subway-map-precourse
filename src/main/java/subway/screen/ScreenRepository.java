package subway.screen;

import java.util.ArrayList;
import java.util.List;

public class ScreenRepository {
    private static final List<Screen> screens = new ArrayList<>();

    public static void addScreen(Screen screen) {
        screens.add(screen);
    }

    public static boolean deleteScreenByType(ScreenType screenType) {
        return screens.removeIf(screen -> screen.getScreenType().equals(screenType));
    }
    
    public static void clear() {
        screens.clear();
    }
    
    public static Screen getScreenByType(ScreenType screenType) {
        return screens.stream()
                .filter(screen -> screen.getScreenType().equals(screenType))
                .findAny()
                .get();
    }
}
