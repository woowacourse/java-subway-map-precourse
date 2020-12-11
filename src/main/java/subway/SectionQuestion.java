package subway;

public enum SectionQuestion implements BaseQuestion {
    REGISTER_STATION("1. 구간 등록", "1") {
        @Override
        public void nextAction(View view) {
            view.registerSection();
            view.mainView();
        }
    },
    DELETE_STATION("2. 구간 삭제", "2") {
        @Override
        public void nextAction(View view) {
            view.deleteSection();
            view.mainView();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.mainView();
        }
    };

    private final static String HEADER = "## 구간 관리 화면";
    private String question;
    private String answerCode;

    SectionQuestion(String question, String answerCode) {
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
