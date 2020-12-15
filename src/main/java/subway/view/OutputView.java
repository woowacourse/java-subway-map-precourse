package subway.view;

import java.util.List;
import subway.domain.selector.menu.Menu;
import subway.domain.station.Station;

public class OutputView {

    public void printScreen(Menu menu) {
        System.out.println("\n## " + menu + " 화면");
        printMenus(menu);
        printItems(menu);
        System.out.println();
    }

    private void printMenus(Menu menu) {
        for (String key : menu.getMenus().keySet()) {
            System.out.println(key + ". " + menu.getMenus().get(key));
        }
    }

    private void printItems(Menu menu) {
        for (String key : menu.getItems().keySet()) {
            System.out.println(key + ". " + menu.getItems().get(key));
        }
    }

    public void printStations(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
    }

}
