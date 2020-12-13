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
    protected static final int MENU_START_INDEX = 1;

    protected String viewName;
    protected HashMap<Selection, T> mapToFunctionType;
    protected Selections selections;

    protected void initializeSelections(List<String> menuIndexs, List<String> descriptions) {
        Iterator<String> menuIndex = menuIndexs.iterator();
        Iterator<String> description = descriptions.iterator();

        List<Selection> selections = new ArrayList<>();
        while(menuIndex.hasNext() && description.hasNext()) {
            selections.add(new Selection(menuIndex.next(), description.next()));
        }

        this.selections = new Selections(selections);
    }

    protected void initializeHashMapToFunctionType(List<Selection> selections, List<T> menuTypes) {
        if (selections.size() != menuTypes.size()) {
            throw new IllegalArgumentException(FATAL_MENU_DATA_CRAHSED);
        }
        Iterator<T> functionType = menuTypes.iterator();
        Iterator<Selection> selection = selections.iterator();

        this.mapToFunctionType = new HashMap<>();
        while (selection.hasNext() && functionType.hasNext()) {
            this.mapToFunctionType.put(selection.next(), functionType.next());
        }
    }

    public void printMenu() {
        OutputView.printMenu(selections, viewName);
    }

    protected T convertToFunctionType(Selection selection){
        return mapToFunctionType.get(selection);
    }

    public T getFunctionSelection() {
        Selection selection = InputView.getSelection(selections);
        return convertToFunctionType(selection);
    }

    protected static void newLine() {
        OutputView.newLine();
    }

    public void printErrorMessage(Exception e) {
        OutputView.printErrorMessage(e);
    }
}
