package subway.question;

import subway.view.View;

public enum LineQuestion implements BaseQuestion {
    REGISTER_STATION("1. 노선 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.registerLine();
            view.main();
        }
    },
    DELETE_STATION("2. 노선 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.deleteLine();
            view.main();
        }
    },
    SHOW_STATIONS("3. 노선 조회", "3") {
        @Override
        public void nextAction(View view) {
            view.printSubwayLineList();
            view.main();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.main();
        }
    };

    private static final String HEADER = "## 노선 관리 화면";
    private String question;
    private String answerCode;

    LineQuestion(String question, String answerCode) {
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
