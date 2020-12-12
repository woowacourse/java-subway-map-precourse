package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RouteRepository {
    private static final List<Route> routemap = new ArrayList<>();

    public static List<Route> routemap() {
        return Collections.unmodifiableList(routemap);
    }

    public static void addRoute(Route route) {
        routemap.add(route);
    }

    public static boolean deleteRoute(Line line) {
        return routemap.removeIf(routemap -> Objects.equals(routemap.getLine(), line));
    }

}
