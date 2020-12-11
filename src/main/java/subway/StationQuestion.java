package subway;

public enum StationQuestion implements BaseQuestion {
    REGISTER_STATION("1. 역 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.registerStation();
            view.mainView();
        }
    },
    DELETE_STATION("2. 역 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.deleteStation();
            view.mainView();
        }
    },
    SHOW_STATIONS("3. 역 조회", "3") {
        @Override
        public void nextAction(View view) {
            view.printStationList();
            view.mainView();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.mainView();
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
