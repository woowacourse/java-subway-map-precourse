package subway.view.navigationViews;

import subway.view.OutputView;
import subway.view.ViewStrategy;
import subway.view.ViewsContainer;

import java.util.Scanner;

public abstract class NavigationViewTemplate {
    protected final Scanner scanner;
    private final ViewsContainer views;
    protected ViewStrategy viewStrategy;

    public NavigationViewTemplate(Scanner scanner) {
        this.scanner = scanner;
        this.views = setViewsContainer();
    }

    protected abstract ViewsContainer setViewsContainer();

    public void show() {
        selectView();
        viewStrategy.execute();
        OutputView.enter();
    }

    private void selectView() {
        OutputView.selectView(navViewName());
        OutputView.printMessage(views.navigate());
        String viewKey = scanner.nextLine();
        viewStrategy = views.getView(viewKey);
        if (viewStrategy == null) {
            OutputView.notExist();
            selectView();
        }
    }

    protected abstract String navViewName();
}
