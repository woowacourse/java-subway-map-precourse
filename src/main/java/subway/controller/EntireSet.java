package subway.controller;

import subway.controller.constants.QuestionNumber;

import java.util.Scanner;

public enum EntireSet {
    STATION(QuestionNumber.ONE.getOption()) {
        public void processSet(Scanner scanner) {
            StationManager stationManager = new StationManager(scanner);
            stationManager.processSector();
        }
    },
    LINE(QuestionNumber.TWO.getOption()) {
        public void processSet(Scanner scanner) {
            LineManager lineManager = new LineManager(scanner);
            lineManager.processSector();
        }
    },
    INTERVAL(QuestionNumber.THREE.getOption()) {
        public void processSet(Scanner scanner) {
            IntervalManager intervalManager = new IntervalManager(scanner);
            intervalManager.processSector();
        }
    },
    ENTIRE_MAP(QuestionNumber.FOUR.getOption()) {
        public void processSet(Scanner scanner) {
            EntireShowManager entireShowManager = new EntireShowManager();
            entireShowManager.processSector();
        }
    },
    QUIT(QuestionNumber.TERMINATE.getOption()) {
        public void processSet(Scanner scanner) {}
    };

    private String option;

    private EntireSet(String option) {
        this.option = option;
    }

    abstract public void processSet(Scanner scanner);

    public String getOption() {
        return option;
    }
}
