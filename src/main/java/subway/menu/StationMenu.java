package subway.menu;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum StationMenu implements MenuModel {
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

    public static MenuModel select(String stationMenuInput) {
        return MenuFeature.findOne(StationMenu.class, stationMenuInput);
    }

    public static String getMenu() {
        return MenuFeature.getMenu(StationMenu.class);
    }

    @Override
    public String getSelection() {
        return selection;
    }

    @Override
    public String getFeature() {
        return feature;
    }
}
