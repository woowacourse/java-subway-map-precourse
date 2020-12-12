package subway.enums;

import subway.Controller;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.StationInputView;

import java.util.Arrays;
import java.util.Scanner;

public enum StationInput {
    register("1", "역 등록") {
        public void moveView(Scanner scanner) {
            StationInputView stationInputView = new StationInputView();
            String station = stationInputView.register(scanner);
            StationRepository.addStation(new Station(station));
        }
    },
    remove("2", "역 삭제") {
        public void moveView(Scanner scanner) {
            StationInputView stationInputView = new StationInputView();
            String station = stationInputView.remove(scanner);
            StationRepository.deleteStation(station);
        }
    },
    inquiry("3", "역 조회") {
        public void moveView(Scanner scanner) {
            // 모든 역 출력
            OutputView.inquiryStation();
        }
    },
    back("B", "돌아가기") {
        public void moveView(Scanner scanner) {
            return;
        }
    };

    final private String inputValue;
    final private String feature;


    private StationInput(String inputValue, String feature) {
        this.inputValue = inputValue;
        this.feature = feature;
    }

    abstract public void moveView(Scanner scanner);

    public static StationInput findOneByInputValue(String viewInput){
        return Arrays.stream(StationInput.values())
                .filter(x -> x.inputValue.equals(viewInput))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static StationInput getInstanceByInput(String viewInput) {
        return findOneByInputValue(viewInput);
    }

    public static String validateInput(String stationViewInput) {
        return findOneByInputValue(stationViewInput).inputValue;
    }

    public static String getMenu() {
        String message = "";
        for (StationInput stationInput : StationInput.values()) {
            message += stationInput.inputValue + ". " + stationInput.feature + "\n";
        }
        return message;
    }

}
