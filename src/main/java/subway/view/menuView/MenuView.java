package subway.view.menuView;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MenuView<T> {
    protected static final String FATAL_MENU_DATA_CRAHSED = "메뉴를 생성할 수 없습니다. ";
    protected static final String MENU_SELECTION = "원하는 기능을 선택하세요.";
    protected static final int MENU_START_INDEX = 1;

    protected String viewName;
    protected HashMap<Selection, T> mapToMenuType;
    protected Selections selections;

    protected void initializeSelections(List<String> menuIndexs, List<String> descriptions) {
        Iterator<String> menuKeys = menuIndexs.iterator();
        Iterator<String> description = descriptions.iterator();

        List<Selection> selections = new ArrayList<>();
        while(menuKeys.hasNext() && description.hasNext()) {
            selections.add(new Selection(menuKeys.next(), description.next()));
        }

        this.selections = new Selections(selections);
    }

    protected void initializeHashMapToMenuType(List<Selection> selections, List<T> menuTypes) {
        if (selections.size() != menuTypes.size()) {
            throw new IllegalArgumentException(FATAL_MENU_DATA_CRAHSED);
        }
        Iterator<T> menuType = menuTypes.iterator();
        Iterator<Selection> selection = selections.iterator();

        this.mapToMenuType = new HashMap<>();
        while (selection.hasNext() && menuType.hasNext()) {
            this.mapToMenuType.put(selection.next(), menuType.next());
        }
    }

    public void printMenu() {
        OutputView.printWithSharpPrefix(viewName);
        for (Selection selection : selections.toList()) {
            OutputView.print(selection);
        }
        newLine();
    }

    public T getMenuSelection() {
        try{
            String input = InputView.getStringWithMessage(MENU_SELECTION);
            Selection selection = selections.searchByKeys(input.toUpperCase());
            return  convertToMenuType(selection);
        } catch (RuntimeException e) {
            OutputView.printErrorMessage(e);
            return getMenuSelection();
        }
    }

    protected T convertToMenuType(Selection selection){
        return mapToMenuType.get(selection);
    }

    protected static void newLine() {
        OutputView.newLine();
    }

    public void printErrorMessage(Exception e) {
        OutputView.printErrorMessage(e);
    }
}
