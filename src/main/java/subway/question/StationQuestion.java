package subway.question;

import subway.service.MainService;
import subway.service.StationService;

public enum StationQuestion implements BaseQuestion {
    REGISTER_STATION("1. 역 등록", "1") {
        @Override
        public void nextAction() {
            StationService.register();
            MainService.main();
        }
    },
    DELETE_STATION("2. 역 삭제", "2") {
        @Override
        public void nextAction() {
            StationService.delete();
            MainService.main();
        }
    },
    SHOW_STATIONS("3. 역 조회", "3") {
        @Override
        public void nextAction() {
            StationService.printStationList();
            MainService.main();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction() {
            MainService.main();
        }
    };

    public static final String HEADER = "## 역 관리 화면";
    private final String option;
    private final String answerCode;

    StationQuestion(String option, String answerCode) {
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
