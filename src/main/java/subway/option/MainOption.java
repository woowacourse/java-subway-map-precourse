package subway.option;

import subway.service.LineService;
import subway.service.MainService;
import subway.service.SectionService;
import subway.service.StationService;

public enum MainOption implements BaseOption {
    TO_STATION_VIEW("1. 역 관리", "1") {
        @Override
        public void nextAction() {
            StationService.view();
        }
    },
    TO_LINE_VIEW("2. 노선 관리", "2") {
        @Override
        public void nextAction() {
            LineService.view();
        }
    },
    TO_INTERVAL_VIEW("3. 구간 관리", "3") {
        @Override
        public void nextAction() {
            SectionService.view();
        }
    },
    PRINT_SUBWAY_ROUTE("4. 지하철 노선도 출력", "4") {
        @Override
        public void nextAction() {
            MainService.printEntireSubwayLine();
            MainService.view();
        }
    },
    QUIT("Q. 종료", "Q") {
        @Override
        public void nextAction() {
        }
    };

    private final String option;
    private final String code;

    MainOption(String option, String code) {
        this.option = option;
        this.code = code;
    }

    @Override
    public String getOption() {
        return option;
    }

    @Override
    public boolean hasCode(String inputCode) {
        return this.code.equals(inputCode);
    }
}
