package subway.menu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum StationMenu {
    REGISTER("1", "역 등록") {
        public void moveView(Scanner scanner) {
            String station = StationInputView.register(scanner);
            StationRepository.addStation(new Station(station));
        }
    },
    REMOVE("2", "역 삭제") {
        public void moveView(Scanner scanner) {
            String station = StationInputView.remove(scanner);
            StationRepository.deleteStation(station);
        }
    },
    INQUIRY("3", "역 조회") {
        public void moveView(Scanner scanner) {
            // 모든 역 출력
            OutputView.inquiryStation();
        }
    },
    BACK("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String selection;
    final private String feature;

    private StationMenu(String selection, String feature) {
        this.selection = selection;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static StationMenu select(String stationMenuInput) {
        return Arrays.stream(StationMenu.values())
                .filter(menu -> menu.selection.equals(stationMenuInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String validateInput(String stationMenuInput) {
        return select(stationMenuInput).selection;
    }

    public static String getMenu() {
        String menuText = "";
        for (StationMenu stationMenu : StationMenu.values()) {
            menuText += stationMenu.selection + ". " + stationMenu.feature + "\n";
        }
        return menuText;
    }

}
