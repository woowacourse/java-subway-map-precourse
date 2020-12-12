package subway.question;

import subway.service.LineService;
import subway.service.MainService;
import subway.service.SectionService;
import subway.service.StationService;

public enum MainQuestion implements BaseQuestion {
    TO_STATION_VIEW("1. 역 관리", "1") {
        @Override
        public void nextAction() {
            StationService.main();
        }
    },
    TO_LINE_VIEW("2. 노선 관리", "2") {
        @Override
        public void nextAction() {
            LineService.main();
        }
    },
    TO_INTERVAL_VIEW("3. 구간 관리", "3") {
        @Override
        public void nextAction() {
            SectionService.main();
        }
    },
    PRINT_SUBWAY_ROUTE("4. 지하철 노선도 출력", "4") {
        @Override
        public void nextAction() {
            MainService.printEntireSubwayLine();
            MainService.main();
        }
    },
    QUIT("Q. 종료", "Q") {
        @Override
        public void nextAction() {
        }
    };

    public static final String HEADER = "## 메인 화면";
    private final String option;
    private final String answerCode;

    MainQuestion(String option, String answerCode) {
        this.option = option;
        this.answerCode = answerCode;
    }

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String getOption() {
        return option;
    }

    @Override
    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
