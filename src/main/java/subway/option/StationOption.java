package subway.option;

import subway.service.MainService;
import subway.service.StationService;

public enum StationOption implements BaseOption {
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

    private final String option;
    private final String code;

    StationOption(String option, String code) {
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
