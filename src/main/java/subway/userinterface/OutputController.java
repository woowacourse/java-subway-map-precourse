package subway.userinterface;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Map;

public class OutputController {
    private static final String STATION_INFO = "\n## 역 목록";
    private static final String LINE_INFO = "\n## 노선 목록";
    private static final String INFO = "[INFO] ";

    public static void printMainMenu(Map<String, Menu> menu, String menuIntro) {
        System.out.println(menuIntro);

        for (String key: menu.keySet()) {
            System.out.println(menu.get(key).getMenuName());
        }
    }

    public static void printInfo(String infoStatement) {
        System.out.println(infoStatement);
    }

    public static void printStationInfo() {
        System.out.println(STATION_INFO);

        StationRepository.stations().forEach(station ->
                System.out.println(INFO+station.getName()));

    }

    public static void printLineInfo() {
        System.out.println(LINE_INFO);

        LineRepository.lines().forEach(line ->
                System.out.println(INFO+line.getName()));

    }

}
