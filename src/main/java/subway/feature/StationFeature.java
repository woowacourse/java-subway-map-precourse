package subway.feature;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.MainMenu;
import subway.menu.StationMenu;
import subway.view.StationInputView;

import java.util.Scanner;

public class StationFeature {
    public static void registerStation(Scanner scanner) {
        try {
            String station = StationInputView.register(scanner);
            StationRepository.addStation(new Station(station));

            System.out.println("[INFO] 지하철 역이 추가되었습니다.");
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    public static void removeStation(Scanner scanner) {
        try {
            String station = StationInputView.remove(scanner);
            StationRepository.deleteStation(station);

            System.out.println("[INFO] 지하철 역이 추가되었습니다.");
        }  catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }
}
