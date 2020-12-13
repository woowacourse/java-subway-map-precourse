package subway.view;

import subway.domain.line.Line;
import subway.domain.section.dto.SectionFindResDto;
import subway.exception.ErrorCode;
import subway.exception.LineException;
import subway.service.output.OutputService;

import java.util.List;

public class LineView extends Screen {
    private static final String LINE_MAIN = Prefix.SHARP.getPrefix() + "노선 관리 화면";
    private static final String LINE_ONE = Prefix.ONE.getPrefix() + "노선 등록";
    private static final String LINE_TWO = Prefix.TWO.getPrefix() + "노선 삭제";
    private static final String LINE_THREE = Prefix.THREE.getPrefix() + "노선 조회";
    private static final String LINE_BACK = Prefix.BACK.getPrefix() + "돌아가기";
    private static final String PRINT_LINE = "노선 목록";
    private static final String PRINT_ADD = "등록할 노선 이름을 입력하세요.";
    private static final String PRINT_ADD_UPWARD = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String PRINT_ADD_DOWNWARD = "등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String PRINT_DELETE = "삭제할 노선 이름을 입력하세요.";
    private static final String PRINT_AFTER_ADD = "지하철 노선이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "지하철 노선이 삭제되었습니다.";
    private static final int ZERO = 0;

    public LineView(OutputService outputService) {
        super(outputService);
    }

    @Override
    public void showOptions() {
        outputService.printOptions(new String[]{LINE_MAIN, LINE_ONE, LINE_TWO, LINE_THREE, LINE_BACK});
    }

    public void printAllLines(List<Line> lines) {
        validateLength(lines);
        outputService.printSharp(PRINT_LINE);
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
    public void showAdd() {
        outputService.printSharp(PRINT_ADD);
    }

    @Override
    public void showDelete() {
        outputService.printSharp(PRINT_DELETE);
    }

    @Override
    public void showAfterAdd() {
        outputService.printInfo(PRINT_AFTER_ADD);
    }

    @Override
    public void showAfterDelete() {
        outputService.printInfo(PRINT_AFTER_DELETE);
    }

    public void showAddUpward() {
        outputService.printSharp(PRINT_ADD_UPWARD);
    }

    public void showAddDownward() {
        outputService.printSharp(PRINT_ADD_DOWNWARD);
    }
}
