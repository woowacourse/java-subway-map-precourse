package subway.view;

import subway.service.output.OutputService;

public class SectionView extends Screen {
    public static final String PRINT_ADD = "노선을 입력하세요.";
    public static final String PRINT_ADD_STATION = "역이름을 입력하세요.";
    public static final String PRINT_ADD_SEQUENCE = "순서를 입력하세요.";
    private static final String PRINT_AFTER_ADD = "구간이 등록되었습니다.";
    private static final int ZERO = 0;

    public SectionView(OutputService outputService) {
        super(outputService);
    }

    @Override
    public String getAdd() {
        return PREFIX_SHARP + PRINT_ADD;
    }

    @Override
    public String getDelete() {
        return null;
    }

    @Override
    public String getAfterAdd() {
        return null;
    }

    @Override
    public String getAfterDelete() {
        return null;
    }
}
