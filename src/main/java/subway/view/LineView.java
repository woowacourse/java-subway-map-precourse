package subway.view;

import subway.domain.line.Line;
import subway.domain.section.dto.SectionFindResDto;
import subway.exception.ErrorCode;
import subway.exception.LineException;
import subway.service.output.OutputService;

import java.util.List;

public class LineView extends Screen {
    private static final String PRINT_ROUTE = "노선 목록";
    public static final String PRINT_ADD = "등록할 노선 이름을 입력하세요.";
    public static final String PRINT_ADD_UPWARD = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String PRINT_ADD_DOWNWARD = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String PRINT_DELETE = "삭제할 노선 이름을 입력하세요.";
    private static final String PRINT_AFTER_ADD = "지하철 노선이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "지하철 노선이 삭제되었습니다.";
    private static final int ZERO = 0;

    public LineView(OutputService outputService) {
        super(outputService);
    }

    public void printAllLines(List<Line> lines) {
        validateLength(lines);
        outputService.printSharp(PRINT_ROUTE);
        for (Line line : lines) {
            SectionFindResDto sectionFindResDto = new SectionFindResDto(line.getName());
            outputService.printInfos(sectionFindResDto.getLineName());
        }
    }

    private void validateLength(List<Line> lines) {
        if (lines.size() == ZERO) {
            throw new LineException(ErrorCode.LINE_NOT_EXIST);
        }
    }

    @Override
    public String getAdd() {
        return PREFIX_SHARP + PRINT_ADD;
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

    public String getAddUpward() {
        return PRINT_ADD_UPWARD;
    }

    public String getAddDownward() {
        return PRINT_ADD_DOWNWARD;
    }
}
