package subway.question;

import subway.view.View;

public enum StationQuestion implements BaseQuestion {
    REGISTER_STATION("1. 역 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.registerStation();
            view.view("Main");
        }
    },
    DELETE_STATION("2. 역 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.deleteStation();
            view.view("Main");
        }
    },
    SHOW_STATIONS("3. 역 조회", "3") {
        @Override
        public void nextAction(View view) {
            view.printStationList();
            view.view("Main");
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.view("Main");
        }
    };

    private static final String HEADER = "## 역 관리 화면";
    private String question;
    private String answerCode;

    StationQuestion(String question, String answerCode) {
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
