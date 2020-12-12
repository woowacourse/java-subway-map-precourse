package subway.option;

import subway.service.MainService;
import subway.service.SectionService;

public enum SectionOption implements BaseOption {
    REGISTER_SECTION("1. 구간 등록", "1") {
        @Override
        public void nextAction() {
            SectionService.register();
            MainService.main();
        }
    },
    DELETE_SECTION("2. 구간 삭제", "2") {
        @Override
        public void nextAction() {
            SectionService.delete();
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

    SectionOption(String option, String code) {
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
