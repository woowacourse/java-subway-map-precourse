package subway.option;

import subway.service.LineService;
import subway.service.MainService;

public enum LineOption implements BaseOption {
    REGISTER_STATION("1. 노선 등록", "1") {
        @Override
        public void nextAction() {
            LineService.register();
        }
    },
    DELETE_STATION("2. 노선 삭제", "2") {
        @Override
        public void nextAction() {
            LineService.delete();
        }
    },
    SHOW_STATIONS("3. 노선 조회", "3") {
        @Override
        public void nextAction() {
            LineService.printSubwayLineList();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction() {
        }
    };

    private final String option;
    private final String code;

    LineOption(String option, String code) {
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
