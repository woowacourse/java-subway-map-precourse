package subway.question;

import subway.service.LineService;
import subway.service.MainService;

public enum LineQuestion implements BaseQuestion {
    REGISTER_STATION("1. 노선 등록", "1") {
        @Override
        public void nextAction() {
            LineService.register();
            MainService.main();
        }
    },
    DELETE_STATION("2. 노선 삭제", "2") {
        @Override
        public void nextAction() {
            LineService.delete();
            MainService.main();
        }
    },
    SHOW_STATIONS("3. 노선 조회", "3") {
        @Override
        public void nextAction() {
            LineService.printSubwayLineList();
            MainService.main();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction() {
            MainService.main();
        }
    };

    public static final String HEADER = "## 노선 관리 화면";
    private String question;
    private String answerCode;

    LineQuestion(String question, String answerCode) {
        this.question = question;
        this.answerCode = answerCode;
    }

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
