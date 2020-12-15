package subway.view;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.selector.menu.Menu;
import subway.domain.station.Station;

public class OutputView {

    private static final String INFORMATION_TAG = "[INFO]";

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
            System.out.println(INFORMATION_TAG + " " + station.getName());
        }
    }

    public void printLines(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(INFORMATION_TAG + " " + line.getName());
        }
    }

    public void printSubwayLineMap(){
        List<Line> lines =  LineRepository.lines();

        for(Line line : lines){
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            for(Station station : line.stations()){
                System.out.println("[INFO] " + station.getName());
            }
            System.out.println();
        }
    }

}
