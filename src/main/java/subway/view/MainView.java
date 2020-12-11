package subway.view;

import subway.MenuType.MainMenuType;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainView {
    private static final String VIEW_NAME = "메인 화면";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String ESCAPE = "종료";
    private static final String ESCAPE_VALUE = "Q";
    private static final int MENU_START_INDEX = 1;

    private static MainView instance;
    private Selections selections;
    private HashMap<Selection, MainMenuType> mapToMainMenuType;

    private MainView() {
        initializeSelection();
        mapToMainMenuType();
    }

    private void initializeSelection() {
        List<String> descriptions = new ArrayList<>(Arrays.asList(
                STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, ESCAPE
        ));
        Iterator<String> description = descriptions.iterator();
        List<Selection> selections = IntStream.range(MENU_START_INDEX, descriptions.size())
                .mapToObj(Integer::toString)
                .map(i -> new Selection(i, description.next()))
                .collect(Collectors.toList());
        selections.add(new Selection(ESCAPE_VALUE, ESCAPE));
        this.selections = new Selections(selections);
    }

    private void mapToMainMenuType() {
        mapToMainMenuType = new HashMap<>();
        Iterator<Selection> selection = selections.toList().iterator();
        for (MainMenuType MainMenuSelection : MainMenuType.values()) {
            mapToMainMenuType.put(selection.next(), MainMenuSelection);
        }
    }

    public static MainView getInstance() {
        if (instance == null) {
            instance = new MainView();
        }
        return instance;
    }

    public void showMenu() {
        OutputView.showMenu(selections, VIEW_NAME);
    }

    public MainMenuType getMainMenuSelection() {
        Selection selection = InputView.getSelection(selections);
        return mapToMainMenuType.get(selection);
    }

}
