package subway.question;

import subway.view.View;

public enum MainQuestion implements BaseQuestion {
    TO_STATION_VIEW("1. 역 관리", "1") {
        @Override
        public void nextAction(View view) {
            view.station();
        }
    },
    TO_LINE_VIEW("2. 노선 관리", "2") {
        @Override
        public void nextAction(View view) {
            view.line();
        }
    },
    TO_INTERVAL_VIEW("3. 구간 관리", "3") {
        @Override
        public void nextAction(View view) {
            view.section();
        }
    },
    PRINT_SUBWAY_ROUTE("4. 지하철 노선도 출력", "4") {
        @Override
        public void nextAction(View view) {
            view.printEntireSubwayLine();
            view.main();
        }
    },
    QUIT("Q. 종료", "Q") {
        @Override
        public void nextAction(View view) {
        }
    };

    private static final String HEADER = "## 메인 화면";
    public String question;
    private String answerCode;

    MainQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    public String getQuestion() {
        return question;
    }

    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
