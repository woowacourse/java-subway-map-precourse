package subway.view.managementView;

import subway.menuType.FunctionType;
import subway.view.InputView;

import java.util.*;
import java.util.stream.Collectors;

public class SectionView extends ManagementView {
    private static final String ITEM_PREFIX = "구간 ";
    private static final String STATION_PREFIX = "역이름을 ";
    private static final String LINE_PREFIX = "노선을 ";
    private static final String INDEX_PREFIX = "순서를 ";
    private static final String SECTION_PREFIX = "구간의 ";
    private static final String REQUEST_MESSAGE = "입력하세요.";
    private static final String SECTION_CREATE = "구간이 등록되었습니다.";
    private static final String SECTION_DELETE = "구간이 삭제되었습니다.";
    private static final String MENU_CREATE = "구간 등록";
    private static final String MENU_DELETE = "구간 삭제";
    private static final String ERROR_INVALID_VALUE = "유효한 입력이 아닙니다.";

    private static SectionView instance;

    private SectionView() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                MENU_CREATE, MENU_DELETE
        ));
        initializeSelections(descriptions);

        initializeHashMapToFunctionType(selections.toList(), Arrays.stream(FunctionType.values())
                        .filter(e -> e != FunctionType.READ)
                        .collect(Collectors.toList()));

        viewName = ITEM_PREFIX + VIEW_NAME;
        itemPrefix = ITEM_PREFIX;
        createMessage = SECTION_CREATE;
        deleteMessage = SECTION_DELETE;
    }

    public static SectionView getInstance() {
        if (instance == null) {
            instance = new SectionView();
        }
        return instance;
    }

    public String getStationNameToCreate() {
        return InputView.getNameWithMessage(SHARP_PREFIX + STATION_PREFIX + REQUEST_MESSAGE);
    }

    public String getStationNameToDelete() {
        return InputView.getNameWithMessage(SHARP_PREFIX + TO_DELETE_PREFIX + SECTION_PREFIX + STATION_PREFIX + REQUEST_MESSAGE);
    }

    public String getLineNameToCreate() {
        return InputView.getNameWithMessage(SHARP_PREFIX + LINE_PREFIX + REQUEST_MESSAGE);
    }

    public String getLineNameToDelete() {
        return InputView.getNameWithMessage(SHARP_PREFIX + TO_DELETE_PREFIX + SECTION_PREFIX + LINE_PREFIX + REQUEST_MESSAGE);
    }

    public int getIndex() {
        String rawString = InputView.getNameWithMessage(SHARP_PREFIX + INDEX_PREFIX + REQUEST_MESSAGE);
        try {
            return Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE);
        }

    }

}
