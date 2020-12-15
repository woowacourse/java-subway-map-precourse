package subway.views;


import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;

public class TotalSubwayMapView {

    public static void showTotalSubwayMap(Scanner scanner) {
        for (int i = 0; i < LineRepository.lines().size(); i++) {
            Line line = LineRepository.lines().get(i);
            List<String> sectionName = line.getSectionName();
            System.out.println(MainView.information + line.getName());
            System.out.println(MainView.intersection);
            for (int j = 0; j < sectionName.size(); j++) {
                System.out.println(MainView.information + sectionName.get(j));
            }
            System.out.println();
        }
        MainView.showSelectManager(scanner);
    }
}
