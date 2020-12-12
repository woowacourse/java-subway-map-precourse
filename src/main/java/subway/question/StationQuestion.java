package subway.question;

import subway.service.StationService;
import subway.view.View;

public enum StationQuestion implements BaseQuestion {
    REGISTER_STATION("1. 역 등록", "1") {
        @Override
        public void nextAction(View view) {
            StationService.register();
            view.main();
        }
    },
    DELETE_STATION("2. 역 삭제", "2") {
        @Override
        public void nextAction(View view) {
            StationService.delete();
            view.main();
        }
    },
    SHOW_STATIONS("3. 역 조회", "3") {
        @Override
        public void nextAction(View view) {
            StationService.printStationList();
            view.main();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction(View view) {
            view.main();
        }
    };

    private final String HEADER = "## 역 관리 화면";
    private String question;
    private String answerCode;

    StationQuestion(String question, String answerCode) {
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
