package subway.domain.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum MainMenuType {
    STATION_MANAGE("1", Arrays.asList(SubMenuType.ADD, SubMenuType.DELETE, SubMenuType.LIST_PRINT, SubMenuType.BACK)),
    LINE_MANAGE("2", Arrays.asList(SubMenuType.ADD, SubMenuType.DELETE, SubMenuType.LIST_PRINT, SubMenuType.BACK)),
    SECTION_MANAGE("3", Arrays.asList(SubMenuType.ADD, SubMenuType.DELETE, SubMenuType.BACK)),
    PRINT_MAP("4", Collections.EMPTY_LIST),
    END_PROGRAM("Q", Collections.EMPTY_LIST);

    private static final String MAIN_MENU_ERROR = "\n[ERROR] 선택할 수 없는 기능입니다.";
    private String text;
    private List<SubMenuType> subMenuTypeList;


    MainMenuType(String text, List<SubMenuType> subMenuTypeList) {
        this.text = text;
        this.subMenuTypeList = subMenuTypeList;
    }

    public static MainMenuType of(String menuInput) {
        return Arrays.stream(MainMenuType.values())
                .filter(menu -> menu.text.equals(menuInput.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    }

    public SubMenuType validateSubMenuOfMainMenu(String menuInput) {
        return subMenuTypeList.stream()
                .filter(subMenu -> subMenu == SubMenuType.of(menuInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MAIN_MENU_ERROR));
    }
}
