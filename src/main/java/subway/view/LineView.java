package subway.view;

import subway.service.output.OutputService;

public class LineView extends Screen {
    private static final String PRINT_ROUTE = "노선 목록";
    public static final String PRINT_ADD = "등록할 노선 이름을 입력하세요";
    public static final String PRINT_DELETE = "삭제할 노선 이름을 입력하세요";
    private static final String PRINT_AFTER_ADD = "지하철 노선이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "지하철 노선이 삭제되었습니다.";

    public LineView(OutputService outputService) {
        super(outputService);
    }

    @Override
    public String getAdd() {
        return PREFIX_INFO + PRINT_ADD;
    }

    @Override
    public String getDelete() {
        return PREFIX_INFO + PRINT_DELETE;
    }

    @Override
    public String getAfterAdd() {
        return PREFIX_INFO + PRINT_AFTER_ADD;
    }

    @Override
    public String getAfterDelete() {
        return PREFIX_INFO + PRINT_AFTER_DELETE;
    }
}
