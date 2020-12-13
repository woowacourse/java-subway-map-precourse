package output;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Menu {
    STATION("역", Arrays.asList(Function.INSERT, Function.DELETE, Function.SEARCH)),
    LINE("노선", Arrays.asList(Function.INSERT, Function.DELETE, Function.SEARCH)),
    ROUTE("구간", Arrays.asList(Function.INSERT, Function.DELETE)),
    SUBWAY_MAP("지하철 노선도", Collections.emptyList()),
    QUIT("종료", Collections.emptyList());

    private final String menuName;
    private final List<Function> menuElement;

    Menu(String menuName, List<Function> menuElement) {
        this.menuName = menuName;
        this.menuElement = menuElement;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public List<Function> getMenuElement() {
        return this.menuElement;
    }
}
