package subway.view;

import subway.domain.section.Section;
import subway.exception.ErrorCode;
import subway.exception.SectionException;
import subway.service.output.OutputService;

import java.util.List;

public class SectionView extends Screen {
    public static final String PRINT_ADD = "노선을 입력하세요.";
    public static final String PRINT_DELETE = "삭제할 구간의 노선을 입력하세요.";
    public static final String PRINT_DELETE_STATION = "삭제할 구간의 역을 입력하세요.";
    public static final String PRINT_ROUTE_MAP = "지하철 노선도";
    public static final String PRINT_ADD_STATION = "역이름을 입력하세요.";
    public static final String PRINT_ADD_SEQUENCE = "순서를 입력하세요.";
    public static final String PRINT_AFTER_ADD = "구간이 등록되었습니다.";
    public static final String PRINT_AFTER_DELETE = "구간이 삭제되었습니다.";
    public static final String PRINT_AVAILABLE_SEQUENCE = "입력가능한 순서는 1~%d 입니다. %d보다 큰수 입력시 마지막 순서가 입력됩니다.";
    private static final int ZERO = 0;

    public SectionView(OutputService outputService) {
        super(outputService);
    }

    public void printAllSection(List<Section> sections) {
        outputService.printSharp(PRINT_ROUTE_MAP);
        validateSectionsLength(sections.size());
        for (Section section : sections) {
            outputService.printInfos(section.getLineName());
            outputService.printInfos(CONTOUR);
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

    @Override
    public String getAdd() {
        return PREFIX_SHARP + PRINT_ADD;
    }

    @Override
    public String getDelete() {
        return PREFIX_SHARP + PRINT_DELETE;
    }

    @Override
    public String getAfterAdd() {
        return PREFIX_SHARP + PRINT_AFTER_ADD;
    }

    @Override
    public String getAfterDelete() {
        return PREFIX_SHARP + PRINT_AFTER_DELETE;
    }
}
