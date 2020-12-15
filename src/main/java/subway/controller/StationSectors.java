package subway.controller;

import subway.controller.constants.QuestionNumber;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.viewer.StationInputViewer;
import subway.viewer.StationOutputViewer;

import java.util.List;
import java.util.Scanner;

public enum StationSectors {
    ADD(QuestionNumber.ONE.getOption()) {
        public void processUnit(Scanner scanner) {
            StationInputViewer.askEnrollStation();
            String stationName = scanner.nextLine();
            StationRepository.addStation(new Station(stationName));
            StationOutputViewer.showEnrollStation();
        }
    },
    DELETE(QuestionNumber.TWO.getOption()) {
        public void processUnit(Scanner scanner) {
            StationInputViewer.askDeleteStation();
            String stationName = scanner.nextLine();
            StationRepository.deleteStation(stationName);
            StationOutputViewer.showDeleteStation();
        }
    },
    CHECK(QuestionNumber.THREE.getOption()) {
        public void processUnit(Scanner scanner) {
            List<Station> stations = StationRepository.stations();
            StationOutputViewer.showStationList(stations);
        }
    },
    BACK(QuestionNumber.BACK.getOption()) {
        public void processUnit(Scanner scanner) {}
    };

    private String option;

    private StationSectors(String option) {
        this.option = option;
    }

    abstract public void processUnit(Scanner scanner);

    public String getOption() {
        return option;
    }
}
