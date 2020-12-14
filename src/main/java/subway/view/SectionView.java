package subway.view;

import subway.domain.section.Section;
import subway.exception.ErrorCode;
import subway.exception.SectionException;
import subway.service.output.OutputService;

import java.util.List;

public class SectionView extends Screen {
    private static final String SECTION_MAIN = Prefix.SHARP.getPrefix() + "구간 관리 화면";
    private static final String SECTION_ONE = Prefix.ONE.getPrefix() + "구간 등록";
    private static final String SECTION_TWO = Prefix.TWO.getPrefix() + "구간 삭제";
    private static final String SECTION_BACK = Prefix.BACK.getPrefix() + "돌아가기";
    private static final String PRINT_ADD = "노선을 입력하세요.";
    private static final String PRINT_DELETE = "삭제할 구간의 노선을 입력하세요.";
    private static final String PRINT_DELETE_STATION = "삭제할 구간의 역을 입력하세요.";
    private static final String PRINT_LINE_MAP = "지하철 노선도";
    private static final String PRINT_ADD_STATION = "역이름을 입력하세요.";
    private static final String PRINT_ADD_SEQUENCE = "순서를 입력하세요.";
    private static final String PRINT_AFTER_ADD = "구간이 등록되었습니다.";
    private static final String PRINT_AFTER_DELETE = "구간이 삭제되었습니다.";
    private static final String PRINT_AVAILABLE_SEQUENCE = "입력가능한 순서는 1~%d 입니다. %d보다 큰수 입력시 마지막 순서가 입력됩니다.";
    private static final int ZERO = 0;
    private static final int CONVERT_SEQUENCE = 1;

    public SectionView(OutputService outputService) {
        super(outputService);
    }

    @Override
    public void showOptions() {
        outputService.printOptions(new String[]{SECTION_MAIN, SECTION_ONE, SECTION_TWO, SECTION_BACK});
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

    public void showAddStation() {
        outputService.printSharp(PRINT_ADD_STATION);
    }

    public void showAvailableSequence(int stationsLength) {
        outputService.printSharp(String.format(PRINT_AVAILABLE_SEQUENCE, stationsLength + CONVERT_SEQUENCE, stationsLength + CONVERT_SEQUENCE));
    }

    public void showAddSequence() {
        outputService.printSharp(PRINT_ADD_SEQUENCE);
    }

    public void showDeleteStation() {
        outputService.printSharp(PRINT_DELETE_STATION);
    }

    public void printAllSection(List<Section> sections) {
        outputService.printSharp(PRINT_LINE_MAP);
        validateSectionsLength(sections.size());
        for (Section section : sections) {
            outputService.printInfos(section.getLineName());
            outputService.printInfos(Prefix.CONTOUR.getPrefix());
            for (String stationName : section.getStationsName()) {
                outputService.printInfos(stationName);
            }
            outputService.printEnter();
        }
    }

    private void validateSectionsLength(int sectionsSize) {
        if (sectionsSize == ZERO) {
            throw new SectionException(ErrorCode.SECTION_NOT_EXIST);
        }
    }
}
